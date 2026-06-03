package es.urjc.grafo.EDA.examen.casoslimpios.emergencias112;

public class Base {

    private final String id;
    private int ambulanciasDisponibles;
    private final String zona;

    public Base(String id, int ambulanciasDisponibles, String zona) {
        this.id = id;
        this.ambulanciasDisponibles = ambulanciasDisponibles;
        this.zona = zona;
    }

    public String getId() { return id; }

    public int getAmbulanciasDisponibles() { return ambulanciasDisponibles; }

    public void setAmbulanciasDisponibles(int ambulanciasDisponibles) { this.ambulanciasDisponibles = ambulanciasDisponibles; }

    public String getZona() { return zona; }
}
