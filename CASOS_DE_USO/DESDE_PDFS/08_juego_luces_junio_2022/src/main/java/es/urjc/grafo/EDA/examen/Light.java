package es.urjc.grafo.EDA.examen;

import java.util.Objects;

public class Light {

    private final int id;
    private boolean on;

    public Light(int id, boolean on) {
        this.id = id;
        this.on = on;
    }

    public int getId() {
        return id;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void toggle() {
        this.on = !this.on;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Light other)) {
            return false;
        }
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
