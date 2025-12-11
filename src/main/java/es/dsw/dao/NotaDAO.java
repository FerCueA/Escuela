package es.dsw.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.dsw.connections.MySqlConnection;
import es.dsw.models.Nota;

/**
 * DAO (Data Access Object) para gestionar las notas
 * Esta clase se encarga de hacer las operaciones con la base de datos
 */
public class NotaDAO {

    // Objeto para manejar la conexión a MySQL
    private MySqlConnection objConexion;

    // Constructor: se ejecuta cuando creas un objeto NotaDAO
    public NotaDAO() {
        objConexion = new MySqlConnection();
    }

    /**
     * Método para obtener TODAS las notas de la base de datos con datos de estudiantes y asignaturas
     * @return List<Nota> - Lista con todas las notas
     */
    public List<Nota> getAllNotas() {

        // PASO 1: Crear una lista vacía donde guardaremos las notas
        List<Nota> listaNotas = new ArrayList<>();
        
        // PASO 2: Abrir la conexión a la base de datos
        objConexion.open();

        // PASO 3: Verificar que la conexión se abrió correctamente
        if (!objConexion.isError()) {

            // PASO 4: Escribir la consulta SQL con JOIN para obtener nombres
            String sql = "SELECT n.id, n.estudiante_id, e.nombre AS estudiante_nombre, " +
                        "e.apellidos AS estudiante_apellido, n.asignatura_id, " +
                        "a.nombre AS asignatura_nombre, n.calificacion " +
                        "FROM notas n " +
                        "INNER JOIN estudiantes e ON n.estudiante_id = e.id " +
                        "INNER JOIN asignaturas a ON n.asignatura_id = a.id " +
                        "ORDER BY e.apellidos, e.nombre, a.nombre";
            
            // PASO 5: Ejecutar la consulta y obtener los resultados
            ResultSet objResulset = objConexion.executeSelect(sql);

            try {
                // PASO 6: Recorrer cada fila del resultado (while)
                while (objResulset.next()) {
                    
                    // PASO 6.1: Crear un nuevo objeto Nota vacío
                    Nota nota = new Nota();
                    
                    // PASO 6.2: Llenar el objeto con los datos de la fila actual
                    nota.setId(objResulset.getLong("id"));
                    nota.setEstudianteId(objResulset.getLong("estudiante_id"));
                    nota.setNombreEstudiante(objResulset.getString("estudiante_nombre"));
                    nota.setApellidosEstudiante(objResulset.getString("estudiante_apellido"));
                    nota.setAsignaturaId(objResulset.getLong("asignatura_id"));
                    nota.setNombreAsignatura(objResulset.getString("asignatura_nombre"));
                    nota.setCalificacion(objResulset.getDouble("calificacion"));

                    // PASO 6.3: Añadir el objeto a la lista
                    listaNotas.add(nota);
                }
            } catch (Exception e) {
                // Si hay algún error, lo imprimimos en consola
                e.printStackTrace();
            } finally {
                // PASO 7: SIEMPRE cerrar la conexión (se ejecuta pase lo que pase)
                objConexion.close();
            }

        } else {
            System.out.println("Error al abrir la conexión:");
        }

        // PASO 8: Devolver la lista con todas las notas
        return listaNotas;
    }
}
