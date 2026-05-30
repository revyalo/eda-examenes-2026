package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDate;

public record Paquete(String localizador, String destino, int prioridad, double peso, LocalDate fechaLimite) {
}
