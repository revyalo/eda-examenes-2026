package es.urjc.grafo.EDA.examen;

import java.time.LocalDate;
import java.util.Collection;

public class InteractionDetector {

    // TODO: Define aquí los atributos necesarios

    /**
     * Almacena una interacción entre dos personas.
     * date - La fecha de la interacción.
     * minutes - El número de minutos que dura la interacción.
     * idPersonA - Entero que identifica de manera unívoca una de las personas en interacción.
     * idPersonB - Entero que identifica de manera unívoca la otra persona en interacción.
     */
    public void storeContact(LocalDate date, int minutes, int idPersonA, int idPersonB) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Devuelve el conjunto de contagio a partir del nodo idRoot. Solo se accede a aquellos
     * nodos que se relacionaron más minutos de los especificados a partir de la fecha especificada.
     */
    public Collection<Integer> getInterestTree(int idRoot, LocalDate date, int minutes) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
