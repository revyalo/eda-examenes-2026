package es.urjc.grafo.EDA.examen.casoslimpios.synthetic;

public class Synthetic_Intel {

    // TODO: declara aqui las estructuras privadas necesarias para el organigrama.

    public Synthetic_Intel(Iterable<ID> employees, Iterable<ManagerRelation> relations) {
        // TODO: construir los indices y la jerarquia a partir de los pares empleado-jefe.
    }

    public Iterable<ID> levelManagers(int level) {
        // TODO: devolver los managers que estan en el nivel indicado.
        throw new UnsupportedOperationException("TODO: levelManagers");
    }

    public Iterable<ID> allMyManagers(String employeeId) {
        // TODO: devolver todos los jefes directos e indirectos hasta el CEO.
        throw new UnsupportedOperationException("TODO: allMyManagers");
    }
}
