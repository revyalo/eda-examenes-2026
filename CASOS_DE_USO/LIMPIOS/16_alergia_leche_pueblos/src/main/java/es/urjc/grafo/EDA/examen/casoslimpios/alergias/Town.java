package es.urjc.grafo.EDA.examen.casoslimpios.alergias;

import java.util.Collection;
import java.util.Set;

public record Town(String name, Set<String> treatedBrands) {

    public Town(String name, Collection<String> treatedBrands) {
        this(name, Set.copyOf(treatedBrands));
    }
}
