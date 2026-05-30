package es.urjc.grafo.EDA.examen.casoslimpios;

import java.time.LocalDateTime;

public class HospitalTriajeLimpio {

    // TODO: declara aqui los atributos privados que necesites.
    // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.

    public HospitalTriajeLimpio() {
        // TODO: inicializa aqui tus estructuras cuando las declares.
    }

    public boolean registrarPaciente(Paciente paciente) {
        // TODO: registrar paciente si no existe.
        throw new UnsupportedOperationException("TODO: registrarPaciente");
    }

    public Paciente siguientePaciente() {
        // TODO: devolver y eliminar el paciente mas grave; desempate por llegada.
        throw new UnsupportedOperationException("TODO: siguientePaciente");
    }

    public boolean cambiarGravedad(String sip, int nuevaGravedad) {
        // TODO: actualizar gravedad manteniendo coherentes tus atributos privados.
        throw new UnsupportedOperationException("TODO: cambiarGravedad");
    }

    public Iterable<Paciente> pacientesEspecialidad(String especialidad) {
        // TODO: devolver pacientes de una especialidad.
        throw new UnsupportedOperationException("TODO: pacientesEspecialidad");
    }

    public Iterable<Paciente> pacientesAntesDe(LocalDateTime fecha) {
        // TODO: devolver pacientes con llegada anterior o igual.
        throw new UnsupportedOperationException("TODO: pacientesAntesDe");
    }

    public boolean altaPaciente(String sip) {
        // TODO: eliminar paciente de todos tus atributos privados.
        throw new UnsupportedOperationException("TODO: altaPaciente");
    }
}
