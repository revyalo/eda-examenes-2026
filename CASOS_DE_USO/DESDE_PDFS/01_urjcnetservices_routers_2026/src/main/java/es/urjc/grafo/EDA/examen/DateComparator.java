package es.urjc.grafo.EDA.examen;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Date> {

    /**
     * Compara dos objetos Date para ordenarlos en orden descendente.
     * Es decir, un objeto Date más reciente se considera "menor" que uno más antiguo.
     * Por ejemplo: si d1 es posterior a d2, compare(d1, d2) devolverá un valor negativo.
     * Si d2 es posterior a d1, compare(d1, d2) devolverá un valor positivo.
     * <p>
     * Nota: la clase Date contiene dos métodos útiles para esta comparación: after() y before().
     *
     * @param d1 the first object to be compared.
     * @param d2 the second object to be compared.
     * @return un valor negativo si d1 es posterior a d2, un valor positivo si d1 es anterior a d2, y 0 si son iguales.
     */
    @Override
    public int compare(Date d1, Date d2) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
