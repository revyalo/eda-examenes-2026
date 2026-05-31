package es.urjc.grafo.EDA.examen;

import java.util.Date;

public record Game(Team homeTeam, Team awayTeam, Date time, String result) {
}
