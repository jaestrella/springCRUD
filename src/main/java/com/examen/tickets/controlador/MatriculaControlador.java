package com.examen.tickets.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examen.tickets.entidad.Matricula;
import com.examen.tickets.servicio.MatriculaServicio;

@Controller
public class MatriculaControlador {

    @Autowired
    private MatriculaServicio servicio;

    @GetMapping({ "/", "" })
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("matriculas", servicio.listarTodasLasMatriculas());
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistroMatricula(Model modelo) {
        modelo.addAttribute("matricula", new Matricula());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    public String registrarNuevaMatricula(@Validated Matricula matricula, BindingResult bindingResult,
            RedirectAttributes redirect, Model modelo) {
                if(bindingResult.hasErrors()){
                    modelo.addAttribute("matricula", matricula);
                    return "nuevo";
                }
                servicio.guardarMatricula(matricula);
                redirect.addFlashAttribute("msgExito", "La matricula ha sido creada");
                return "redirect:/";
    }

    @GetMapping("/{cod_matricula}/editar")
    public String mostrarFormularioDeEditarMatricula(@PathVariable Long cod_matricula, Model modelo){
        
        modelo.addAttribute("matricula", servicio.obtenerMatriculaPorId(cod_matricula));
        return "nuevo";
    }

    @PostMapping("/{cod_matricula}/editar")
    public String actualizarMatricula(@PathVariable Long cod_matricula, @Validated Matricula matricula,
            BindingResult bindingResult,
            RedirectAttributes redirect, Model modelo) {

        Matricula matriculaDB = servicio.obtenerMatriculaPorId(cod_matricula);


        if (bindingResult.hasErrors()) {
            modelo.addAttribute("matricula", matriculaDB);
            return "nuevo";
        }
        
        matriculaDB.setDni(matricula.getDni());
        matriculaDB.setNombre_alumno(matricula.getNombre_alumno());
        matriculaDB.setTelefono(matricula.getTelefono());

        servicio.actualizarMatricula(matriculaDB);
        redirect.addFlashAttribute("msgExito", "La matricula ha sido actualizada correctamente");
        return "redirect:/";
    }

    @PostMapping("/{cod_matricula}/eliminar")
    public String eliminarMatricula(@PathVariable Long cod_matricula, RedirectAttributes redirect){
        servicio.eliminarMatricula(cod_matricula);
        redirect.addFlashAttribute("msgExito", "La matricula ha sido eliminada correctamente");
        return "redirect:/";
    }


}
