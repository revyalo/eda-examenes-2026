package es.urjc.grafo.EDA.examen.casoslimpios;

import java.time.LocalDate;

public record Contacto(int personaA, int personaB, LocalDate fecha, int minutos) {
}
