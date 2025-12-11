package es.dsw.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Alumno;


public class AlumnoDAO {

    private MySqlConnection objConexion;
    public AlumnoDAO() {
        objConexion = new MySqlConnection();
    }
    
    public List<Alumno> getAllAlumnos() {

         List<Alumno> listaAlumnos = new ArrayList<>();
         objConexion.open();

         if (!objConexion.isError()) {

             String sql = "SELECT id, nombre, apellidos FROM estudiantes";
             ResultSet objResulset = objConexion.executeSelect(sql);

             try {
                 while (objResulset.next()) {

                     Alumno alumno = new Alumno();
                     alumno.setId(objResulset.getLong("id"));
                     alumno.setNombre(objResulset.getString("nombre"));
                     alumno.setApellido(objResulset.getString("apellidos"));

                     listaAlumnos.add(alumno);
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             } finally {
                 objConexion.close();
             }
         } else {
             System.out.println("Error de conexión a la base de datos.");
         }



        return listaAlumnos;
    }

}
