package es.dsw.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.dsw.dao.AlumnoDAO;
import es.dsw.dao.asignaturasDAO;
import es.dsw.dao.NotaDAO;
import es.dsw.models.Alumno;
import es.dsw.models.Asignatura;
import es.dsw.models.Nota;

@Controller
public class MainController {

    @GetMapping({ "/", "/index" })
    public String index() {
        return "index";
    }

    @GetMapping("/nav/alumnos")
    public String alumnos( Model model) {

        AlumnoDAO dao = new AlumnoDAO();
        List<Alumno> listaAlumnos = dao.getAllAlumnos();
        model.addAttribute("alumnos", listaAlumnos);

        return "nav/alumnos";
    }

    @GetMapping("/nav/asignaturas")
    public String asignaturas(Model model) {

        // 1. Crear una instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();

        // 2. Llamar al método que obtiene las asignaturas
        List<Asignatura> listaAsignaturas = dao.getAllAsignaturas();

        // 3. Pasar los datos a la vista usando model.addAttribute()
        model.addAttribute("asignaturas", listaAsignaturas);

        // 4. Retornar el nombre de la vista
        return "nav/asignaturas";
    }

    @GetMapping("/nav/notas")
    public String notas(Model model) {
        
        // 1. Crear una instancia del DAO
        NotaDAO dao = new NotaDAO();
        
        // 2. Llamar al método que obtiene las notas
        List<Nota> listaNotas = dao.getAllNotas();
        
        // 3. Pasar los datos a la vista usando model.addAttribute()
        model.addAttribute("notas", listaNotas);
        
        // 4. Retornar el nombre de la vista
        return "nav/notas";
    }


    // Método 1: Mostrar el formulario (cuando haces clic en "Agregar Asignatura")
    @GetMapping("/nav/asignaturas/agregar")
    public String mostrarFormularioAgregar() {
        // Retorna la vista del formulario
        return "nav/agregar-asignatura";
    }

    // Método 2: Procesar el formulario y guardar en la BD (cuando haces Submit)
    @PostMapping("/nav/asignaturas/guardar")
    public String guardarAsignatura(@RequestParam("nombre") String nombre, 
                                    @RequestParam("descripcion") String descripcion) {
        
        // 1. Crear instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();
        
        // 2. Llamar al método insertAsignatura
        dao.insertAsignatura(nombre, descripcion);
        
        // 3. Redireccionar a la lista de asignaturas (vuelves a /nav/asignaturas)
        return "redirect:/nav/asignaturas";
    }

    @GetMapping("/nav/asignaturas/eliminar")
    public String eliminarAsignatura(@RequestParam("id") Long id) {
        
        // 1. Crear instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();
        
        // 2. Llamar al método deleteAsignatura
        dao.deleteAsignatura(id);
        
        // 3. Redireccionar a la lista de asignaturas
        return "redirect:/nav/asignaturas";
    }

}
