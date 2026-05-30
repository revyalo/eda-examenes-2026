package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

public class RedSocialExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public RedSocialExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addUsuario(Usuario usuario) {
        // TODO: registrar usuario sin nick duplicado.
        throw new UnsupportedOperationException("TODO: addUsuario");
    }

    public boolean seguir(String origen, String destino) {
        // TODO: crear relacion dirigida origen -> destino.
        throw new UnsupportedOperationException("TODO: seguir");
    }

    public Iterable<Usuario> sugerencias(String nick) {
        // TODO: devolver usuarios a distancia dos que nick aun no sigue.
        throw new UnsupportedOperationException("TODO: sugerencias");
    }

    public boolean publicar(Publicacion publicacion) {
        // TODO: registrar publicacion para moderacion si procede.
        throw new UnsupportedOperationException("TODO: publicar");
    }

    public Publicacion siguientePostAModerar() {
        // TODO: devolver publicacion con mas denuncias.
        throw new UnsupportedOperationException("TODO: siguientePostAModerar");
    }
}
