package es.urjc.grafo.EDA.examen.casoslimpios.organiser;

import java.util.List;

public class Organiser {

    // TODO: declara aqui los atributos privados necesarios para localizar por DNI en O(1).

    public Organiser() {
        // TODO: inicializar estructuras.
    }

    public Organiser(List<SubjectStudentPair> initialRegistrations) {
        // TODO: construir el organizador a partir de pares asignatura-estudiante.
    }

    public List<String> enrolledSubjects(DNI dni) {
        // TODO: devolver las asignaturas del estudiante o null si no existe.
        throw new UnsupportedOperationException("TODO: enrolledSubjects");
    }

    public void newStudent(Student student, List<String> subjects) {
        // TODO: alta o modificacion de matricula.
        throw new UnsupportedOperationException("TODO: newStudent");
    }

    public void registrationChange(Student student, List<String> subjects) {
        // TODO: modificar matricula de estudiante ya existente; lanzar excepcion si no existe.
        throw new UnsupportedOperationException("TODO: registrationChange");
    }

    public String studentData(DNI dni) {
        // TODO: devolver nombre apellido dni o null si no existe.
        throw new UnsupportedOperationException("TODO: studentData");
    }
}
