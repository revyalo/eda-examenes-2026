package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectoralCollegeTest {

    @Test
    void colegioReparteVotantesPorDniEntreMesas() {
        ElectoralCollege college = new ElectoralCollege();
        college.addVoter("333333333B", "c/ Lila", "Pedro Serrano Vega");
        college.addVoter("111111111A", "c/ Clavel", "Juan Perez Perez");
        college.addVoter("222222222A", "c/ Petunia", "Andres Martin Palomo");
        college.addVoter("444444444C", "c/ Leonidas", "Daniel Vela Amor");

        college.makeStationDistribution();

        assertIterableEquals(java.util.List.of(
                new Voter("111111111A", "c/ Clavel", "Juan Perez Perez"),
                new Voter("222222222A", "c/ Petunia", "Andres Martin Palomo"),
                new Voter("333333333B", "c/ Lila", "Pedro Serrano Vega"),
                new Voter("444444444C", "c/ Leonidas", "Daniel Vela Amor")
        ), college.getAllVoters());
        assertEquals('A', college.getStation("111111111A"));
        assertEquals(4, college.getStationVoters('A').size());
        assertNull(college.getStation("999999999Z"));
    }
}
