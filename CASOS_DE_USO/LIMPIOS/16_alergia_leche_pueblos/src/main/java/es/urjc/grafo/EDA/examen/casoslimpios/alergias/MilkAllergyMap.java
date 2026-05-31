package es.urjc.grafo.EDA.examen.casoslimpios.alergias;

import java.util.Collection;

public class MilkAllergyMap {

    // TODO: declara aqui los mapas, conjuntos o indices necesarios.

    public MilkAllergyMap() {
        // TODO: inicializar estructuras.
    }

    public boolean addTown(String name, Collection<String> treatedBrands) {
        // TODO: registrar pueblo y marcas tratables.
        throw new UnsupportedOperationException("TODO: addTown");
    }

    public boolean addRoad(String a, String b) {
        // TODO: conectar dos pueblos existentes con carretera bidireccional.
        throw new UnsupportedOperationException("TODO: addRoad");
    }

    public String milkSafeTown() {
        // TODO: devolver el pueblo que minimiza el peor salto a marcas tratables.
        throw new UnsupportedOperationException("TODO: milkSafeTown");
    }

    public boolean survive(String town, String milkBrand, int maxVisitedTowns) {
        // TODO: comprobar si existe centro tratable a distancia estrictamente menor que maxVisitedTowns.
        throw new UnsupportedOperationException("TODO: survive");
    }

    public boolean survive(String town, int maxVisitedTowns) {
        // TODO: variante del enunciado original si decides almacenar internamente la marca peligrosa.
        throw new UnsupportedOperationException("TODO: survive");
    }
}
