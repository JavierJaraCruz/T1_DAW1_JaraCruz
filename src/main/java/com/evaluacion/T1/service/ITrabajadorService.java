package com.evaluacion.T1.service;

import com.evaluacion.T1.model.Trabajador;

import java.util.List;

public interface ITrabajadorService {

    List<Trabajador> obtenerTrabajadores();
    Trabajador guardarTrabajador(Trabajador trabajador);

    Trabajador obtenerTrabajadorPorId(Integer id);

    Trabajador actualizarTrabajador(Integer id, Trabajador trabajador);
    void eliminarTrabajador(Integer id);

}
