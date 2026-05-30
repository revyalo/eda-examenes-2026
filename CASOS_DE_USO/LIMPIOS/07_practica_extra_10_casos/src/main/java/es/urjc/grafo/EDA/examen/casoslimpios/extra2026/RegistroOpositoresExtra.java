package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

public class RegistroOpositoresExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public RegistroOpositoresExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addOpositor(OpositorExtra opositor) {
        // TODO: insertar opositor si su DNI no existe.
        throw new UnsupportedOperationException("TODO: addOpositor");
    }

    public boolean actualizarNota(String dni, double nuevaNota, boolean apto) {
        // TODO: actualizar nota/estado y mantener coherentes tus atributos.
        throw new UnsupportedOperationException("TODO: actualizarNota");
    }

    public Iterable<OpositorExtra> top(int n) {
        // TODO: devolver los n mejores por nota, con desempate estable.
        throw new UnsupportedOperationException("TODO: top");
    }

    public Iterable<OpositorExtra> aptosPorProvincia(String provincia) {
        // TODO: devolver aptos de la provincia.
        throw new UnsupportedOperationException("TODO: aptosPorProvincia");
    }

    public Iterable<OpositorExtra> opositoresEntreNotas(double min, double max) {
        // TODO: devolver opositores con nota en [min, max].
        throw new UnsupportedOperationException("TODO: opositoresEntreNotas");
    }
}
