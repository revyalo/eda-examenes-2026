package es.urjc.grafo.EDA.examen;

import java.util.Collection;

public class RedSocial {

    // TODO: define aqui los atributos privados necesarios.

    public Persona newProfile(String username) {
        // TODO: registrar un nuevo perfil unico o devolver null si ya existe.
        throw new UnsupportedOperationException("TODO: newProfile");
    }

    public boolean wantToBeFollower(Persona follower, Persona followed) {
        // TODO: hacer que follower siga a followed si ambos estan registrados.
        throw new UnsupportedOperationException("TODO: wantToBeFollower");
    }

    public Collection<Persona> followers(Persona p) {
        // TODO: devolver perfiles que siguen a p.
        throw new UnsupportedOperationException("TODO: followers");
    }

    public Collection<Persona> following(Persona p) {
        // TODO: devolver perfiles a los que sigue p.
        throw new UnsupportedOperationException("TODO: following");
    }

    public Collection<Persona> suggestions(Persona p) {
        // TODO: usuarios que siguen perfiles que p sigue, excluyendo ya seguidos.
        throw new UnsupportedOperationException("TODO: suggestions");
    }

    public Collection<Persona> suspiciousBot() {
        // TODO: devolver perfiles sin seguidores.
        throw new UnsupportedOperationException("TODO: suspiciousBot");
    }

    public Collection<Persona> cleanBots() {
        // TODO: eliminar iterativamente todos los perfiles considerados bots.
        throw new UnsupportedOperationException("TODO: cleanBots");
    }
}
