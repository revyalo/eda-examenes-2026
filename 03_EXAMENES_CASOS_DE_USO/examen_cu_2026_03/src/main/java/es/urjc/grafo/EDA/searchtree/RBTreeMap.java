package es.urjc.grafo.EDA.searchtree;

import es.urjc.grafo.EDA.util.Entry;
import es.urjc.grafo.EDA.util.Position;

import java.util.Comparator;

/**
 * An implementation of a sorted map using a red-black tree.
 *
 * @param <K> The key type (keys must be unique and comparable)
 * @param <V> The value type
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class RBTreeMap<K,V> extends AbstractBalanceableTreeMap<K,V> {

    /** Constructs an empty map using the natural ordering of keys. */
    public RBTreeMap() { super(); }

    /**
     * Constructs an empty map using the given comparator to order keys.
     * @param comp comparator defining the order of keys in the map
     */
    public RBTreeMap(Comparator<K> comp) { super(comp); }

    // we use the inherited aux field with convention that 0=black and 1=red
    // (note that new leaves will be black by default, as aux=0)
    private boolean isBlack(Position<Entry<K,V>> p) { return tree.getAux(p)==0;}

    private boolean isRed(Position<Entry<K,V>> p) { return tree.getAux(p)==1; }

    private void makeBlack(Position<Entry<K,V>> p) { tree.setAux(p, 0); }

    private void makeRed(Position<Entry<K,V>> p) { tree.setAux(p, 1); }

    private void setColor(Position<Entry<K,V>> p, boolean toRed) {
        tree.setAux(p, toRed ? 1 : 0);
    }

    /**
     * Rebalancea el árbol tras una inserción.
     * Resuelve el problema del doble rojo si es necesario.
     * @param p la posición del nodo recién insertado.
     */
    @Override
    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        // Si p fuese la raíz, no habría que hacer nada, porque los nodos creados son negros por defecto
        if (!isRoot(p)) {
            // Si no es la raíz, lo coloreamos de rojo
            makeRed(p);
            // Ahora podemos tener un doble rojo
            resolveDoubleRed(p);
        }
    }

    /**
     * Recibe un nodo rojo (p) y resuelve el doble rojo si su padre también es rojo.
     * @param p una posición de un nodo rojo
     */
    private void resolveDoubleRed(Position<Entry<K,V>> p) {
        if(isRoot(p)){
            makeBlack(p);
            return;
        }
        Position<Entry<K, V>> parent = parent(p);
        if(isBlack(parent)){
            return;
        }

        Position<Entry<K, V>> grand = parent(parent);

        Position<Entry<K, V>> uncle = sibling(parent);

        if(isBlack(uncle)){
            p = restructure(p);
            makeBlack(p);
            makeRed(left(p));
            makeRed(right(p));
        }else{
            makeBlack(parent);
            makeBlack(uncle);
            makeRed(grand);
            resolveDoubleRed(grand);
        }


    }

    /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        // p es el hijo del nodo eliminado
        if (isRed(p))
            // Si p es rojo, entonces el nodo eliminado (padre de p) era negro, porque no puede haber dos rojos seguidos
            // Por lo tanto, en este caso, el nodo eliminado no era rojo y tenía un hijo rojo
            // Recoloreamos p a negro
            makeBlack(p);
        else if (!isRoot(p)) {
            Position<Entry<K,V>> sib = sibling(p);
            if (isInternal(sib) && (isBlack(sib) || isInternal(left(sib))))
                // Ahora sabemos que el padre de p NO era rojo
                // Por lo tanto, el padre de p era negro y no tenía hijos rojos
                resolveDoubleBlack(p);
        }
    }


    /**
     * Este método resuelve un problema de doble negro en el árbol.
     * Cuando se llama a este método tras una operación de borrado,
     * p es la posición del nodo que ocupa la posición del nodo borrado.
     * En este punto, ya sabemos que el nodo eliminado no era rojo ni tenía ningún hijo rojo.
     * @param p posición del nodo que ocupa el lugar del nodo eliminado.
     */
    private void resolveDoubleBlack(Position<Entry<K,V>> p) {
        while(!isRoot(p)){
            Position<Entry<K, V>> Z = parent(p);
            Position<Entry<K, V>> S = sibling(p);

            if(isRed(S)){
                makeBlack(S);
                makeRed(Z);
                tree.rotate(S);
                S = sibling(p);
            }

            Position<Entry<K, V>> Rleft = left(S);
            Position<Entry<K, V>> Rright= right(S);

            if(isBlack(Rleft) && isBlack(Rright)){
                makeRed(S);
                if(isRed(Z)){
                    makeBlack(Z);
                    return;
                }else{
                    p = Z;
                }
            }else{
                Position<Entry<K, V>> R;
                if(S == right(Z)){
                    R = isRed(Rright) ? Rright : Rleft;

                }else{
                    R = isRed(Rleft) ? Rleft : Rright;
                }
                Position<Entry<K, V>> newGrand = restructure(R);
                setColor(newGrand, isRed(Z));
                makeBlack(left(newGrand));
                makeBlack(right(newGrand));
                return;
            }







        }
    }

    /** Ensure that current tree structure is valid RB tree (for debugging only)*/
    private boolean sanityCheck() {
        if (sanityRecurse(root()) == -1) {
            System.out.println("VIOLATION of RB tree properties");
            dump();
            return false;
        } else
            return true;
    }

    /** Returns black depth of subtree, if valid, or -1 if invalid. */
    private int sanityRecurse(Position<Entry<K,V>> p) {
        if (isExternal(p)) {
            if (isRed(p)) return -1;                     // invalid; should be black
            else return 0;                               // valid, with black-depth 0
        } else {
            if (isRoot(p) && isRed(p)) return -1;        // root must be black
            Position<Entry<K,V>> left = left(p);
            Position<Entry<K,V>> right = right(p);
            if (isRed(p) && (isRed(left) || isRed(right))) return -1;   // cannot have double red

            int a = sanityRecurse(left);
            if (a == -1) return -1;
            int b = sanityRecurse(right);
            if (a != b) return -1;                       // two subtrees must have identical black depth

            return a + (isRed(p) ? 0 : 1);               // our black depth might be one greater
        }
    }

    /**
     * Overriding method to print whether a node is red or black.
     * @param p
     * @param depth
     * @param sb
     * @return
     */
    @Override
    protected StringBuilder dumpRecurse(Position<Entry<K,V>> p, int depth, StringBuilder sb) {
        String indent = (depth == 0 ? "" : String.format("%" + (2*depth) + "s", ""));
        if (isExternal(p))
            sb.append(indent).append("leaf\n");
        else {
            sb.append(indent).append(p.getElement()).append("(").append(this.isRed(p) ? "Red" : "Black").append(")\n");
            dumpRecurse(left(p), depth+1, sb);
            dumpRecurse(right(p), depth+1, sb);
        }
        return sb;
    }
}
