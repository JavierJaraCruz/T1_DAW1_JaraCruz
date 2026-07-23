package com.evaluacion.T1.service;

import com.evaluacion.T1.model.Trabajador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrabajadorService implements ITrabajadorService {
    List<Trabajador> trabajadores = new ArrayList<>();

    private int contador = 6;


    //iniciar con trabajadores de prueba
    public TrabajadorService() {

        trabajadores.add(
                Trabajador.builder()
                        .id(1)
                        .nombres("Javier")
                        .apellidos("Jara")
                        .cargo("Estudiante")
                        .salario(2000.00)
                        .estado("Activo")
                        .build()
        );


        trabajadores.add(
                Trabajador.builder()
                        .id(2)
                        .nombres("Rodolfo")
                        .apellidos("Jara")
                        .cargo("Analista")
                        .salario(3000.00)
                        .estado("Activo")
                        .build()
        );


        trabajadores.add(
                Trabajador.builder()
                        .id(3)
                        .nombres("Andrew")
                        .apellidos("Jara")
                        .cargo("Programador")
                        .salario(4000.00)
                        .estado("Activo")
                        .build()
        );


        trabajadores.add(
                Trabajador.builder()
                        .id(4)
                        .nombres("Jose")
                        .apellidos("Jara")
                        .cargo("Administrador")
                        .salario(5000.00)
                        .estado("Activo")
                        .build()
        );


        trabajadores.add(
                Trabajador.builder()
                        .id(5)
                        .nombres("Sara")
                        .apellidos("Jara")
                        .cargo("Diseñadora")
                        .salario(6000.00)
                        .estado("Activo")
                        .build()
        );
    }




    @Override
    public List<Trabajador> obtenerTrabajadores(){


       /* Trabajador trabajador1 = Trabajador.builder().id(1) .nombres("Javier")
                .apellidos("Jara")
                .cargo("Estudiante")
                .salario(2000.00)
                .estado("Activo")
                .build();

        Trabajador trabajador2 =  Trabajador.builder().id(2) .nombres("Rodolfo")
                .apellidos("Jara")
                .cargo("Estudiante")
                .salario(3000.00)
                .estado("Activo")
                .build();
        Trabajador trabajador3 = Trabajador.builder().id(3) .nombres("Andrew")
                .apellidos("Jara")
                .cargo("Estudiante")
                .salario(4000.00)
                .estado("Activo")
                .build();
        Trabajador trabajador4 =Trabajador.builder().id(4) .nombres("Jose")
                .apellidos("Jara")
                .cargo("Estudiante")
                .salario(5000.00)
                .estado("Activo")
                .build();
        Trabajador trabajador5 = Trabajador.builder().id(5) .nombres("Sara")
                .apellidos("Jara")
                .cargo("Estudiante")
                .salario(6000.00)
                .estado("Activo")
                .build();
        return List.of(trabajador1,trabajador2,trabajador3,trabajador4,trabajador5);*/
        return trabajadores;
    }
    @Override
    public Trabajador guardarTrabajador(Trabajador trabajador){

        trabajador.setId(contador++);

        trabajadores.add(trabajador);

        return trabajador;
    }
    @Override
    public Trabajador obtenerTrabajadorPorId(Integer id) {

        for (Trabajador trabajador : trabajadores) {

            if (trabajador.getId().equals(id)) {
                return trabajador;
            }

        }

        return null;
    }


    @Override
    public Trabajador actualizarTrabajador(Integer id, Trabajador trabajadorActualizado) {

        for (Trabajador trabajador : trabajadores) {

            if (trabajador.getId().equals(id)) {

                trabajador.setNombres(trabajadorActualizado.getNombres());
                trabajador.setApellidos(trabajadorActualizado.getApellidos());
                trabajador.setCargo(trabajadorActualizado.getCargo());
                trabajador.setSalario(trabajadorActualizado.getSalario());
                trabajador.setEstado(trabajadorActualizado.getEstado());

                break;
            }

        }

        return trabajadorActualizado;
    }

    @Override
    public void eliminarTrabajador(Integer id){

        trabajadores.removeIf(
                trabajador -> trabajador.getId().equals(id)
        );

    }
}
