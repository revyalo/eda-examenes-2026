package es.urjc.grafo.EDA.examen.casoslimpios.synthetic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SyntheticIntelTest {

    private static List<String> ids(Iterable<ID> values) {
        List<String> result = new ArrayList<>();
        for (ID value : values) {
            result.add(value.id());
        }
        return result;
    }

    private static Set<String> idSet(Iterable<ID> values) {
        return ids(values).stream().collect(Collectors.toSet());
    }

    @Test
    void basicEdDevuelveEquipoDirectoDelJefe() {
        NewBasicED ed = new NewBasicED();
        ID ceo = new ID("CEO", "Ana");
        ID a = new ID("A", "Luis");
        ID b = new ID("B", "Marta");
        ed.addRelation(a, ceo);
        ed.addRelation(b, ceo);

        assertEquals(Set.of("A", "B"), idSet(ed.team("CEO")));
    }

    @Test
    void syntheticIntelConsultaNivelesYJefes() {
        List<ID> employees = List.of(
                new ID("CEO", "Ana"),
                new ID("CTO", "Luis"),
                new ID("CFO", "Marta"),
                new ID("DEV1", "Pablo"),
                new ID("DEV2", "Lucia")
        );
        List<ManagerRelation> relations = List.of(
                new ManagerRelation("CTO", "CEO"),
                new ManagerRelation("CFO", "CEO"),
                new ManagerRelation("DEV1", "CTO"),
                new ManagerRelation("DEV2", "CTO")
        );

        Synthetic_Intel intel = new Synthetic_Intel(employees, relations);

        assertEquals(Set.of("CTO", "CFO"), idSet(intel.levelManagers(1)));
        assertEquals(List.of("CTO", "CEO"), ids(intel.allMyManagers("DEV1")));
        assertEquals(List.of(), ids(intel.allMyManagers("CEO")));
    }
}
