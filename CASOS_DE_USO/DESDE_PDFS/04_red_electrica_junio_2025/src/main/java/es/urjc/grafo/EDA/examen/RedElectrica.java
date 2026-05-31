package es.urjc.grafo.EDA.examen;

import java.util.Collection;

public class RedElectrica {

    // TODO: define aqui los atributos privados necesarios.

    public RedElectrica() {
        // TODO: inicializar la red de areas.
    }

    public void anadirArea(Area a) {
        // TODO: anadir el area a la red.
        throw new UnsupportedOperationException("TODO: anadirArea");
    }

    public boolean conectarAreas(Area a1, Area a2) {
        // TODO: conectar dos areas si procede.
        throw new UnsupportedOperationException("TODO: conectarAreas");
    }

    public int energiaGeneradaActualmente() {
        // TODO: devolver la energia total generada por la red.
        throw new UnsupportedOperationException("TODO: energiaGeneradaActualmente");
    }

    public Collection<Area> areasActivas() {
        // TODO: devolver las areas que producen energia.
        throw new UnsupportedOperationException("TODO: areasActivas");
    }

    public boolean colapsoDescontrolado(Collection<Area> c) {
        // TODO: comprobar si las areas colapsadas apagan toda la red en un salto.
        throw new UnsupportedOperationException("TODO: colapsoDescontrolado");
    }
}
