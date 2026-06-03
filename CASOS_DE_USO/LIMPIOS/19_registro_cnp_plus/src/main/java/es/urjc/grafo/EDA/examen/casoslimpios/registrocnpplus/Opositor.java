package es.urjc.grafo.EDA.examen.casoslimpios.registrocnpplus;

public record Opositor(Integer dni, String nombre, double notaTeoria, double notaFisica, double notaPsicotecnica) {

    public double notaMedia() {
        return (notaTeoria + notaFisica + notaPsicotecnica) / 3.0;
    }
}
