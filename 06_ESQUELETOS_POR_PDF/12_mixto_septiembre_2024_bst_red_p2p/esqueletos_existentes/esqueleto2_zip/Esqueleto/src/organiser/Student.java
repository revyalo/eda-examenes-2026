package organiser;

/**
 * @author mayte
 */
public record Student(String name, String lastname, DNI dni) {

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return this.dni.equals(other.dni);
    }

    @Override
    public String toString() {
        return "Student: " + "name=" + name + ", lastname=" + lastname + ", dni=" + dni.toString();
    }


}
