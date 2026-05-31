package es.urjc.grafo.EDA.examen.casoslimpios.organiser;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganiserTest {

    @Test
    void constructorYConsultasPorDni() {
        Student ana = new Student("Ana", "Ruiz", new DNI("111A"));
        Student luis = new Student("Luis", "Soto", new DNI("222B"));
        Organiser organiser = new Organiser(List.of(
                new SubjectStudentPair("EDA", ana),
                new SubjectStudentPair("ALG", ana),
                new SubjectStudentPair("EDA", luis)
        ));

        assertEquals(List.of("EDA", "ALG"), organiser.enrolledSubjects(new DNI("111A")));
        assertEquals("Ana Ruiz 111A", organiser.studentData(new DNI("111A")));
        assertNull(organiser.enrolledSubjects(new DNI("999Z")));
    }

    @Test
    void newStudentYRegistrationChangeActualizanMatricula() {
        Organiser organiser = new Organiser();
        Student ana = new Student("Ana", "Ruiz", new DNI("111A"));

        organiser.newStudent(ana, List.of("EDA", "ALG"));
        assertEquals(List.of("EDA", "ALG"), organiser.enrolledSubjects(new DNI("111A")));

        organiser.registrationChange(ana, List.of("EDA2"));
        assertEquals(List.of("EDA2"), organiser.enrolledSubjects(new DNI("111A")));

        assertThrows(IllegalArgumentException.class,
                () -> organiser.registrationChange(new Student("Eva", "Lopez", new DNI("333C")), List.of("EDA")));
    }
}
