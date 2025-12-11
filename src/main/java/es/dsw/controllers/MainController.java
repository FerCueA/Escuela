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


    // CRGAR VISTA DE AGREGAR ASIGNATURA
    @GetMapping("/nav/asignaturas/agregar")
    public String mostrarFormularioAgregar() {
        // Retorna la vista del formulario
        return "nav/agregar-asignatura";
    }

    // AGREGAR ASINGATURA
    @PostMapping("/nav/asignaturas/guardar")
    public String guardarAsignatura(@RequestParam("nombre") String nombre, 
                                    @RequestParam("descripcion") String descripcion) {
        
        // 1. Crear instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();
        
        // 2. Llamar al método insertAsignatura
        dao.insertAsignatura(nombre, descripcion);
        
        // 3. Redireccionar a la lista de asignaturas
        return "redirect:/nav/asignaturas";
    }

    // ELIMINAR ASIGNATURA
    @GetMapping("/nav/asignaturas/eliminar")
    public String eliminarAsignatura(@RequestParam("id") Long id) {
        
        // 1. Crear instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();
        
        // 2. Llamar al método deleteAsignatura
        dao.deleteAsignatura(id);
        
        // 3. Redireccionar a la lista de asignaturas
        return "redirect:/nav/asignaturas";
    }

    // CARGAR VISTAS DE LA ASINGATURA A EDITAR 
    @GetMapping("/nav/asignaturas/editar")
    public String mostrarFormularioEditar(@RequestParam("id") Long id, Model model) {
        
        // 1. Crear instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();
        
        // 2. Obtener la asignatura por ID
        Asignatura asignatura = dao.getAsignaturaById(id);
        
        // 3. Pasar la asignatura a la vista
        model.addAttribute("asignatura", asignatura);
        
        // 4. Retornar la vista de editar
        return "nav/editar-asignatura";
    }

    // ACTUALZIAR LOS DATOS EN LA BASE DE DATOS
    @PostMapping("/nav/asignaturas/actualizar")
    public String actualizarAsignatura(@RequestParam("id") Long id,
                                       @RequestParam("nombre") String nombre,
                                       @RequestParam("descripcion") String descripcion) {
        
        // 1. Crear instancia del DAO
        asignaturasDAO dao = new asignaturasDAO();
        
        // 2. Llamar al método updateAsignatura
        dao.updateAsignatura(id, nombre, descripcion);
        
        // 3. Redireccionar a la lista de asignaturas
        return "redirect:/nav/asignaturas";
    }

}
