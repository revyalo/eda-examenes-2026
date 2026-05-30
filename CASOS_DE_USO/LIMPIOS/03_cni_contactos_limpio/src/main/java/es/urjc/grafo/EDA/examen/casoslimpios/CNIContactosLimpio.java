package es.urjc.grafo.EDA.examen.casoslimpios;

import java.time.LocalDate;

public class CNIContactosLimpio {

    // TODO: declara aqui los atributos privados que necesites.
    // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.

    public CNIContactosLimpio() {
        // TODO: inicializa aqui tus estructuras cuando las declares.
    }

    public boolean addAgente(Agente agente) {
        // TODO: registrar agente sin duplicados.
        throw new UnsupportedOperationException("TODO: addAgente");
    }

    public boolean registrarContacto(Contacto contacto) {
        // TODO: guardar el contacto si sus dos agentes existen.
        throw new UnsupportedOperationException("TODO: registrarContacto");
    }

    public boolean contactoDirecto(int a, int b) {
        // TODO: comprobar si existe un contacto directo entre ambos agentes.
        throw new UnsupportedOperationException("TODO: contactoDirecto");
    }

    public Iterable<Agente> grupoDeRiesgo(int origen, LocalDate desde, int minutosMinimos) {
        // TODO: recorrer contactos validos con fecha >= desde y minutos >= minutosMinimos.
        throw new UnsupportedOperationException("TODO: grupoDeRiesgo");
    }

    public boolean posibleCadena(int origen, int destino, int maxSaltos) {
        // TODO: comprobar si hay cadena de contactos con longitud <= maxSaltos.
        throw new UnsupportedOperationException("TODO: posibleCadena");
    }
}
