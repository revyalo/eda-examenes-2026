package es.urjc.grafo.EDA.examen;

import java.util.List;

public class PlayOfLight {

    // TODO: define aqui los atributos privados necesarios.

    public PlayOfLight(List<Light> lights, List<Light[]> connections) {
        // TODO: cargar luces y conexiones iniciales.
    }

    public void changeTheState(Light light) {
        // TODO: cambiar la luz y sus vecinas directas.
        throw new UnsupportedOperationException("TODO: changeTheState");
    }

    public boolean endOfGame() {
        // TODO: true si todas las luces restantes estan encendidas o todas apagadas.
        throw new UnsupportedOperationException("TODO: endOfGame");
    }

    public void updateGame() {
        // TODO: eliminar luces cuyas vecinas comparten exactamente su estado.
        throw new UnsupportedOperationException("TODO: updateGame");
    }

    public Iterable<Light> lightsOn() {
        // TODO: devolver luces encendidas.
        throw new UnsupportedOperationException("TODO: lightsOn");
    }

    public Iterable<Light> lightsOff() {
        // TODO: devolver luces apagadas.
        throw new UnsupportedOperationException("TODO: lightsOff");
    }
}
