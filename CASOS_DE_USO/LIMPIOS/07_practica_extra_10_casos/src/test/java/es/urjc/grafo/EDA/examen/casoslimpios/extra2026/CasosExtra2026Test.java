package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CasosExtra2026Test {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    @Test
    void emergenciasAtiendePorUrgenciaYFecha() {
        Emergencias112 sistema = new Emergencias112();
        LocalDateTime ahora = LocalDateTime.of(2026, 1, 10, 10, 0);
        Incidencia leve = new Incidencia("I1", 2, ahora, "Mostoles", "Averia");
        Incidencia grave = new Incidencia("I2", 5, ahora.minusMinutes(3), "Alcorcon", "Accidente");

        assertTrue(sistema.registrarIncidencia(leve));
        assertTrue(sistema.registrarIncidencia(grave));
        assertFalse(sistema.registrarIncidencia(leve));
        assertEquals(grave, sistema.atenderSiguiente());
        assertEquals("Mostoles", sistema.municipioConMasIncidencias());
    }

    @Test
    void opositoresRankingProvinciaYRango() {
        RegistroOpositoresExtra registro = new RegistroOpositoresExtra();
        registro.addOpositor(new OpositorExtra("1", "Ana", "Soto", "Madrid", 7.5, true));
        registro.addOpositor(new OpositorExtra("2", "Luis", "Rios", "Madrid", 9.0, true));
        registro.addOpositor(new OpositorExtra("3", "Eva", "Mora", "Toledo", 6.0, false));

        assertEquals("2", toList(registro.top(1)).get(0).dni());
        assertEquals(2, toList(registro.aptosPorProvincia("Madrid")).size());
        assertEquals(2, toList(registro.opositoresEntreNotas(7.0, 10.0)).size());
    }

    @Test
    void paquetesPrioridadFechaYDestino() {
        PaquetesLogistica logistica = new PaquetesLogistica();
        LocalDate hoy = LocalDate.of(2026, 2, 1);
        logistica.registrarPaquete(new Paquete("P1", "Madrid", 1, 2.0, hoy.plusDays(2)));
        logistica.registrarPaquete(new Paquete("P2", "Madrid", 5, 1.0, hoy));

        assertEquals("P2", logistica.siguienteEntrega().localizador());
        assertEquals(1, logistica.eliminarDestino("Madrid"));
    }

    @Test
    void reservasProcesaSolicitudCompatible() {
        ReservasAulasExtra reservas = new ReservasAulasExtra();
        LocalDateTime inicio = LocalDateTime.of(2026, 3, 1, 9, 0);
        reservas.registrarAula(new Aula("A1", 40, "Fuenlabrada"));
        reservas.solicitarReserva(new SolicitudReserva("S1", "EDA", inicio, 120, 3, 30));

        Reserva reserva = reservas.procesarSiguienteSolicitud();
        assertEquals("A1", reserva.aula());
        assertEquals(1, toList(reservas.reservasEntre(inicio.minusHours(1), inicio.plusHours(3))).size());
    }

    @Test
    void multasConsultaRankingYPago() {
        MultasTraficoExtra trafico = new MultasTraficoExtra();
        LocalDate dia = LocalDate.of(2026, 4, 5);
        trafico.registrarMulta(new Multa("M1", "1111AAA", dia, 100.0, "LEVE", false));
        trafico.registrarMulta(new Multa("M2", "1111AAA", dia.plusDays(1), 500.0, "GRAVE", false));

        assertEquals(2, toList(trafico.multasDeMatricula("1111AAA")).size());
        assertEquals("M2", toList(trafico.topMultasMasCaras(1)).get(0).codigo());
        assertTrue(trafico.pagarMulta("M1"));
    }

    @Test
    void bibliotecaPrestamosReservasYTop() {
        BibliotecaExtra biblioteca = new BibliotecaExtra();
        LocalDate devolucion = LocalDate.of(2026, 5, 1);
        biblioteca.addLibro(new Libro("ISBN1", "EDA", "URJC", "Informatica", 0, null));
        assertTrue(biblioteca.prestarLibro("ISBN1", "u1", devolucion));
        assertTrue(biblioteca.reservarLibro(new ReservaLibro("R1", "ISBN1", "u2", LocalDateTime.of(2026, 4, 1, 10, 0), 2)));
        assertEquals(1, toList(biblioteca.devolucionesHasta(devolucion)).size());
        assertEquals("ISBN1", toList(biblioteca.librosTopPrestados(1)).get(0).isbn());
    }

    @Test
    void subastasAceptaMejorPujaYCierra() {
        SubastasExtra subastas = new SubastasExtra();
        LocalDateTime cierre = LocalDateTime.of(2026, 6, 1, 12, 0);
        subastas.crearSubasta(new Producto("P1", "Portatil", cierre, 300.0));
        assertTrue(subastas.pujar(new Puja("P1", "ana", 350.0, cierre.minusHours(1))));
        assertFalse(subastas.pujar(new Puja("P1", "luis", 320.0, cierre.minusMinutes(30))));
        assertEquals("ana", subastas.ganador("P1").usuario());
        assertEquals(1, toList(subastas.cerrarSubastasHasta(cierre)).size());
    }

    @Test
    void redSocialSugiereYModera() {
        RedSocialExtra red = new RedSocialExtra();
        red.addUsuario(new Usuario("ana", "Madrid"));
        red.addUsuario(new Usuario("bea", "Madrid"));
        red.addUsuario(new Usuario("carlos", "Toledo"));
        red.seguir("ana", "bea");
        red.seguir("bea", "carlos");
        red.publicar(new Publicacion("P1", "carlos", LocalDateTime.of(2026, 7, 1, 8, 0), 9));

        assertEquals("carlos", toList(red.sugerencias("ana")).get(0).nick());
        assertEquals("P1", red.siguientePostAModerar().id());
    }

    @Test
    void hipergrafoRelacionaPorProyectos() {
        HipergrafoProyectosExtra hipergrafo = new HipergrafoProyectosExtra();
        hipergrafo.addProyecto(new Proyecto("PR1", "Saturno"));
        hipergrafo.addProyecto(new Proyecto("PR2", "Marte"));
        hipergrafo.addParticipante(new Participante("A", "Ana"));
        hipergrafo.addParticipante(new Participante("B", "Bea"));
        hipergrafo.asignar("A", "PR1");
        hipergrafo.asignar("B", "PR1");

        assertEquals(1, toList(hipergrafo.participantesRelacionados("A")).size());
        assertEquals("PR1", toList(hipergrafo.proyectosComunes("A", "B")).get(0).id());
    }

    @Test
    void vuelosDirigidosEscalasFechasYSalidas() {
        VuelosExtra vuelos = new VuelosExtra();
        LocalDateTime salida = LocalDateTime.of(2026, 8, 1, 9, 0);
        vuelos.addAirport(new AeropuertoExtra("MAD", "Madrid"));
        vuelos.addAirport(new AeropuertoExtra("BCN", "Barcelona"));
        vuelos.addAirport(new AeropuertoExtra("VLC", "Valencia"));
        vuelos.addFlight(new VueloExtra("V1", "MAD", "BCN", salida));
        vuelos.addFlight(new VueloExtra("V2", "BCN", "VLC", salida.plusHours(2)));

        assertTrue(vuelos.conexionConMaxEscalas("MAD", "VLC", 1));
        assertEquals(2, toList(vuelos.vuelosEntre(salida.minusMinutes(1), salida.plusHours(3))).size());
        assertEquals("MAD", vuelos.aeropuertoConMasSalidas().codigo());
    }
}
