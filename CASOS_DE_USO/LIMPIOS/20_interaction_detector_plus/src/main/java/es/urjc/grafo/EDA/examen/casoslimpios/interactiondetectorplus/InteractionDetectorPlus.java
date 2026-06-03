package es.urjc.grafo.EDA.examen.casoslimpios.interactiondetectorplus;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

public class InteractionDetectorPlus {

    // TODO: declara las propiedades privadas para personas e interacciones entre pares.

    public void storeContact(LocalDate date, int minutes, int idPersonA, int idPersonB) {
        throw new UnsupportedOperationException("TODO: storeContact");
    }

    public Collection<Integer> getInterestTree(int idRoot, LocalDate date, int minutes) {
        throw new UnsupportedOperationException("TODO: getInterestTree");
    }

    public Map<Integer, Integer> getInterestLevels(int idRoot, LocalDate date, int minutes) {
        throw new UnsupportedOperationException("TODO: getInterestLevels");
    }

    public Integer mostConnectedSuspect(int idRoot, LocalDate date, int minutes) {
        throw new UnsupportedOperationException("TODO: mostConnectedSuspect");
    }
}
