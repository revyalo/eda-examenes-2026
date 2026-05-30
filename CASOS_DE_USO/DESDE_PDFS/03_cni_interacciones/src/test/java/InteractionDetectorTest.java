import es.urjc.grafo.EDA.examen.InteractionDetector;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InteractionDetectorTest {

    public InteractionDetectorTest() {
    }

    @Test
    public void testStoreContact() {
        LocalDate day1 = LocalDate.of(2023, 7, 1);
        LocalDate day2 = LocalDate.of(2023, 7, 2);
        LocalDate day3 = LocalDate.of(2023, 7, 3);

        InteractionDetector detector = new InteractionDetector();

        detector.storeContact(day1, 13, 1, 2);
        detector.storeContact(day2, 3, 1, 4);

        detector.storeContact(day2, 10, 2, 3);

        detector.storeContact(day2, 8, 3, 4);
        detector.storeContact(day1, 3, 3, 6);
        detector.storeContact(day1, 15, 3, 7);

        detector.storeContact(day3, 15, 4, 5);
        detector.storeContact(day1, 5, 6, 7);

        detector.storeContact(day2, 10, 5, 7);
        detector.storeContact(day1, 8, 5, 10);
        detector.storeContact(day3, 8, 5, 8);
    }

    @Test
    public void testGetInterestTree() {
        LocalDate day1 = LocalDate.of(2023, 7, 1);
        LocalDate day2 = LocalDate.of(2023, 7, 2);
        LocalDate day3 = LocalDate.of(2023, 7, 3);

        InteractionDetector detector = new InteractionDetector();

        detector.storeContact(day1, 13, 1, 2);
        detector.storeContact(day2, 3, 1, 4);

        detector.storeContact(day2, 10, 2, 3);

        detector.storeContact(day2, 8, 3, 4);
        detector.storeContact(day1, 3, 3, 6);
        detector.storeContact(day1, 15, 3, 7);

        detector.storeContact(day3, 15, 4, 5);
        detector.storeContact(day1, 5, 6, 7);

        detector.storeContact(day2, 10, 5, 7);
        detector.storeContact(day1, 8, 5, 10);
        detector.storeContact(day3, 8, 5, 8);

        Collection<Integer> result = detector.getInterestTree(2, day2, 5);

        Set<Integer> expResult = new HashSet<>();
        expResult.add(2);
        expResult.add(3);
        expResult.add(4);
        expResult.add(5);
        expResult.add(7);
        expResult.add(8);

        assertTrue(result.containsAll(expResult));
        assertTrue(expResult.containsAll(result));
    }

}
