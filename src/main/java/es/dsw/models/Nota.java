package es.dsw.models;

public class Nota {
    
    private Long id;
    private Long estudianteId;
    private String nombreEstudiante;
    private String apellidosEstudiante;
    private Long asignaturaId;
    private String nombreAsignatura;
    private Double calificacion;

    // Constructor vacío
    public Nota() {
    }

    // Constructor completo
    public Nota(Long id, Long estudianteId, String nombreEstudiante, String apellidosEstudiante, 
                Long asignaturaId, String nombreAsignatura, Double calificacion) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidosEstudiante = apellidosEstudiante;
        this.asignaturaId = asignaturaId;
        this.nombreAsignatura = nombreAsignatura;
        this.calificacion = calificacion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidosEstudiante() {
        return apellidosEstudiante;
    }

    public void setApellidosEstudiante(String apellidosEstudiante) {
        this.apellidosEstudiante = apellidosEstudiante;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}
