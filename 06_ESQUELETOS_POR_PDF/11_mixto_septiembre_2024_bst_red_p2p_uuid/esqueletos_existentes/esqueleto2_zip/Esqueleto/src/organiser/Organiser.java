package organiser;

import utils.Pair;

import java.util.List;

public class Organiser {

    /**
     * Initializes the organiser
     */
    public Organiser() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Initializes the organiser
     */
    public Organiser(List<Pair<String, List<Student>>> lista) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns the list of subject in which the student is enrolled, or null if the student is not in the organiser.
     */
    public List<String> enrolledSubjects(DNI dni) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Adds a new student and their list of subject to the organiser.
     * If the student is already in the organiser, it is a change of record
     */
    public void newStudent(Student s, List<String> l) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Receives a student and a new list of subjects.
     * If the student is not in the organiser, throws an exception.
     */
    public void registrationChange(Student s, List<String> l) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns a string with the student's personal data.
     * If the student is not in the organiser, returns null.
     */
    public String studentData(DNI dni) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


}
