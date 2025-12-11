package es.dsw.models;
import java.util.Objects;

public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;

    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Alumno id(Long id) {
        setId(id);
        return this;
    }

    public Alumno nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Alumno apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id) && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellido, alumno.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            "}";
    }
    

}
