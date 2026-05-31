package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyntheticIntelTest {

    @Test
    void estructuraIntermediaDevuelveEquipoDirecto() {
        ID ceo = new ID("ceo");
        ID manager = new ID("manager");
        ID dev = new ID("dev");
        NewBasicED ed = new NewBasicED(java.util.List.of(
                new ID[]{manager, ceo},
                new ID[]{dev, manager}
        ));

        assertIterableEquals(java.util.List.of(manager), ed.team(ceo));
        assertIterableEquals(java.util.List.of(dev), ed.team(manager));
    }

    @Test
    void organigramaConsultaNivelesYJefes() {
        ID ceo = new ID("ceo");
        ID manager = new ID("manager");
        ID dev = new ID("dev");
        NewBasicED ed = new NewBasicED(java.util.List.of(
                new ID[]{manager, ceo},
                new ID[]{dev, manager}
        ));
        Synthetic_Intel empresa = new Synthetic_Intel(ceo, ed);

        assertIterableEquals(java.util.List.of(manager), empresa.levelManagers(1));
        assertIterableEquals(java.util.List.of(manager, ceo), empresa.allMyManagers(dev));
        assertIterableEquals(java.util.List.of(), empresa.allMyManagers(ceo));
    }
}
