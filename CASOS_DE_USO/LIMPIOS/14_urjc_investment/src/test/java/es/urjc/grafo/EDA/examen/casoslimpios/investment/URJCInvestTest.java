package es.urjc.grafo.EDA.examen.casoslimpios.investment;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class URJCInvestTest {

    @Test
    void insertaEmpresaBuscaOrganigramaYDevuelveHojas() {
        URJCInvest invest = new URJCInvest();
        assertTrue(invest.insertEmployee("Acme", "Ana", "CEO", null));
        assertTrue(invest.insertEmployee("Acme", "Luis", "CTO", "Ana"));
        assertTrue(invest.insertEmployee("Acme", "Marta", "Dev", "Luis"));
        assertTrue(invest.insertEmployee("Acme", "Pablo", "Dev", "Luis"));

        OrganizationChart chart = invest.searchCompany("Acme");
        assertNotNull(chart);
        assertEquals("Ana", chart.getCeo().name());
        assertEquals("Luis", invest.searchEmployee("Luis").name());

        Set<String> leaves = chart.getGrantHolders().stream().map(Employee::name).collect(Collectors.toSet());
        assertEquals(Set.of("Marta", "Pablo"), leaves);
    }
}
