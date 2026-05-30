package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDate;

public class MultasTraficoExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public MultasTraficoExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean registrarMulta(Multa multa) {
        // TODO: registrar multa sin codigo duplicado.
        throw new UnsupportedOperationException("TODO: registrarMulta");
    }

    public Iterable<Multa> multasDeMatricula(String matricula) {
        // TODO: devolver multas de una matricula.
        throw new UnsupportedOperationException("TODO: multasDeMatricula");
    }

    public Iterable<Multa> multasEntreFechas(LocalDate inicio, LocalDate fin) {
        // TODO: devolver multas en el rango.
        throw new UnsupportedOperationException("TODO: multasEntreFechas");
    }

    public Iterable<Multa> topMultasMasCaras(int n) {
        // TODO: devolver las n multas de mayor importe.
        throw new UnsupportedOperationException("TODO: topMultasMasCaras");
    }

    public boolean pagarMulta(String codigo) {
        // TODO: marcar como pagada y mantener coherentes tus atributos.
        throw new UnsupportedOperationException("TODO: pagarMulta");
    }
}
