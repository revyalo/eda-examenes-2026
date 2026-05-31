package es.urjc.grafo.EDA.examen.casoslimpios.mensajes;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlataformaMensajesTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    @Test
    void difusionBorradoYCentralidad() {
        PlataformaMensajes plataforma = new PlataformaMensajes();
        plataforma.addUsuario(new UsuarioPlataforma("A", "Ana", "Madrid"));
        plataforma.addUsuario(new UsuarioPlataforma("B", "Bea", "Madrid"));
        plataforma.addUsuario(new UsuarioPlataforma("C", "Carlos", "Toledo"));
        plataforma.seguir("A", "B");
        plataforma.seguir("B", "C");

        assertEquals(2, toList(plataforma.usuariosAlcanzables("A", 1)).size());

        LocalDateTime fecha = LocalDateTime.of(2026, 2, 1, 12, 0);
        plataforma.enviarMensaje(new MensajePlataforma("M1", "A", fecha, 2, "hola"));
        assertEquals(1, plataforma.borrarMensajesHasta(fecha));
        assertEquals("B", plataforma.usuarioCentral().id());
    }
}
