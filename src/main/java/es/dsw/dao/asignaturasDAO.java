package es.dsw.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import es.dsw.connections.MySqlConnection;
import es.dsw.models.Asignatura;


public class asignaturasDAO {

    // Objeto para manejar la conexión a MySQL
    private MySqlConnection objConexion;

    // Constructor: se ejecuta cuando creas un objeto asignaturasDAO
    public asignaturasDAO() {
        objConexion = new MySqlConnection();
    }

    /**
     * Método para obtener TODAS las asignaturas de la base de datos
     * @return List<Asignatura> - Lista con todas las asignaturas
     */
    public List<Asignatura> getAllAsignaturas() {

        // PASO 1: Crear una lista vacía donde guardaremos las asignaturas
        List<Asignatura> listaAsignaturas = new ArrayList<>();
        
        // PASO 2: Abrir la conexión a la base de datos
        objConexion.open();

        // PASO 3: Verificar que la conexión se abrió correctamente
        if (!objConexion.isError()) {

            // PASO 4: Escribir la consulta SQL (SELECT)
            String sql = "SELECT id, nombre, descripcion FROM asignaturas";
            
            // PASO 5: Ejecutar la consulta y obtener los resultados
            ResultSet objResulset = objConexion.executeSelect(sql);

            try {
                // PASO 6: Recorrer cada fila del resultado (while)
                while (objResulset.next()) {
                    
                    // PASO 6.1: Crear un nuevo objeto Asignatura vacío
                    Asignatura asignatura = new Asignatura();
                    
                    // PASO 6.2: Llenar el objeto con los datos de la fila actual
                    asignatura.setId(objResulset.getLong("id"));
                    asignatura.setNombre(objResulset.getString("nombre"));
                    asignatura.setDescripcion(objResulset.getString("descripcion"));

                    // PASO 6.3: Añadir el objeto a la lista
                    listaAsignaturas.add(asignatura);
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

        // PASO 8: Devolver la lista con todas las asignaturas
        return listaAsignaturas;
    }

    public boolean insertAsignatura(String nombre, String descripcion) {
    
        // PASO 1: Abrir la conexión
        objConexion.open();
        
        // PASO 2: Verificar que no hay error
        if (!objConexion.isError()) {
            
            // PASO 3: Escribir la consulta SQL INSERT
            String sql = "INSERT INTO asignaturas (nombre, descripcion) VALUES ('" + nombre + "', '" + descripcion + "')";
            
            try {
                // PASO 4: Ejecutar el INSERT
                ResultSet rs = objConexion.executeInsert(sql);
                
                // PASO 5: Si rs no es null, significa que se insertó correctamente
                if (rs != null && rs.next()) {
                    // Aquí puedes obtener el ID generado si lo necesitas
                    long idGenerado = rs.getLong(1);
                    System.out.println("Asignatura insertada con ID: " + idGenerado);
                    return true;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // PASO 6: Cerrar la conexión
                objConexion.close();
            }
        }
        
        return false;
    }

    public boolean deleteAsignatura(Long id) {
        
        // PASO 1: Abrir la conexión
        objConexion.open();
        
        // PASO 2: Verificar que no hay error
        if (!objConexion.isError()) {
            
            // PASO 3: Escribir la consulta SQL DELETE
            String sql = "DELETE FROM asignaturas WHERE id = " + id;
            
            try {
                // PASO 4: Ejecutar el DELETE
                int filasAfectadas = objConexion.executeUpdateOrDelete(sql);
                
                // PASO 5: Si se eliminó al menos una fila, retornar true
                if (filasAfectadas > 0) {
                    return true;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // PASO 6: Cerrar la conexión
                objConexion.close();
            }
        }
        
        return false;
    }
}
