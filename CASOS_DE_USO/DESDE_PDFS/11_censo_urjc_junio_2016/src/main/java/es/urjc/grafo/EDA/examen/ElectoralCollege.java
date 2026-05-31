package es.urjc.grafo.EDA.examen;

import java.util.Collection;

public class ElectoralCollege {

    // TODO: define aqui los atributos privados necesarios.

    public ElectoralCollege() {
        // TODO: inicializar el colegio electoral.
    }

    public void addVoter(String dni, String street, String fullName) {
        // TODO: almacenar un votante posible.
        throw new UnsupportedOperationException("TODO: addVoter");
    }

    public void makeStationDistribution() {
        // TODO: repartir los votantes entre mesas de como maximo 800 personas.
        throw new UnsupportedOperationException("TODO: makeStationDistribution");
    }

    public Collection<Voter> getAllVoters() {
        // TODO: devolver todo el censo ordenado por DNI.
        throw new UnsupportedOperationException("TODO: getAllVoters");
    }

    public Collection<Voter> getStationVoters(char station) {
        // TODO: devolver votantes de la mesa indicada, ordenados por DNI.
        throw new UnsupportedOperationException("TODO: getStationVoters");
    }

    public Character getStation(String dni) {
        // TODO: devolver la mesa asignada al DNI, o null si no existe.
        throw new UnsupportedOperationException("TODO: getStation");
    }
}
