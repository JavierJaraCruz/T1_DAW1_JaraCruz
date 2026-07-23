package com.evaluacion.T1.controller;

import com.evaluacion.T1.model.Trabajador;
import com.evaluacion.T1.service.ITrabajadorService;
import com.evaluacion.T1.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trabajadores")
@RequiredArgsConstructor  //lombok
public class Pregunta1Controller {

    private final ITrabajadorService iTrabajadorService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("trabajadores", iTrabajadorService.obtenerTrabajadores());
        return "pregunta1";

    }

    @GetMapping("/registroApellido")
    public String registroApellido(Model model){



        model.addAttribute("trabajador", new Trabajador());
        model.addAttribute("ruta", "/trabajadores/guardar");

        return "registroApellido";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Trabajador trabajador){

        iTrabajadorService.guardarTrabajador(trabajador);

        return "redirect:/trabajadores";
    }
    @GetMapping("/registroApellido/{id}")
    public String editar(@PathVariable Integer id, Model model){

        model.addAttribute("trabajador",
                iTrabajadorService.obtenerTrabajadorPorId(id));

        model.addAttribute("ruta",
                "/trabajadores/actualizar/"+id);

        return "registroApellido";
    }


    @PostMapping("/actualizar/{id}")
    public String actualizar(
            @PathVariable Integer id,
            @ModelAttribute Trabajador trabajador){

        iTrabajadorService.actualizarTrabajador(id, trabajador);

        return "redirect:/trabajadores";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){

        iTrabajadorService.eliminarTrabajador(id);

        return "redirect:/trabajadores";
    }
}
