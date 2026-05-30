package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDate;

public record Libro(String isbn, String titulo, String autor, String categoria, int prestamos, LocalDate fechaDevolucion) {
}
