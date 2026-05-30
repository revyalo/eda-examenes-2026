package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDate;

public record Multa(String codigo, String matricula, LocalDate fecha, double importe, String gravedad, boolean pagada) {
}
