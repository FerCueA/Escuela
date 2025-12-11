package es.dsw.models;

import java.util.Objects;

public class Asignatura {

    private long id;
    private String nombre;
    private String descripcion;

    public Asignatura() {
    }

    public Asignatura(long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asignatura id(long id) {
        setId(id);
        return this;
    }

    public Asignatura nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Asignatura descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Asignatura)) {
            return false;
        }
        Asignatura asignatura = (Asignatura) o;
        return id == asignatura.id && Objects.equals(nombre, asignatura.nombre)
                && Objects.equals(descripcion, asignatura.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                "}";
    }

}
