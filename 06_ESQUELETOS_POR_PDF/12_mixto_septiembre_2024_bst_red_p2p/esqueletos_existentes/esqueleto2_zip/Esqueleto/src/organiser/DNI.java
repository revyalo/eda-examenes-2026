package organiser;

import java.util.Objects;

public record DNI(long number, char letter) {

    @Override
    public int hashCode() {
        return Objects.hash(number, letter);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final DNI other = (DNI) obj;
        return this.number == other.number && this.letter == other.letter;
    }

    @Override
    public String toString() {
        return number + "-" + letter;
    }

}
