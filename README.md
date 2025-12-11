#  Sistema de Gestión Escolar - Proyecto de Aprendizaje

> **Nota:** Este es un proyecto de aprendizaje personal creado durante mi tercer año. El objetivo principal es entender cómo funciona Spring Boot, Thymeleaf y la conexión con bases de datos MySQL.

##  ¿Qué es esto?

Es una aplicación web simple para gestionar información de una escuela: alumnos, asignaturas y notas. Lo estoy haciendo para practicar y aprender sobre:

- **Spring Boot** (Framework de Java)
- **Thymeleaf** (Motor de plantillas HTML)
- **MySQL** (Base de datos)
- **CRUD básico** (Crear, Leer, Actualizar, Eliminar)
- **MVC** (Modelo-Vista-Controlador)

##  Tecnologías que estoy usando

- **Java 17**
- **Spring Boot 3.x**
- **Thymeleaf**
- **MySQL**
- **Bootstrap 5** (para que no se vea tan feo)
- **Maven** (gestor de dependencias)

## Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── es/dsw/
│   │       ├── app/              # Clase principal
│   │       ├── connections/      # Conexión a MySQL
│   │       ├── controllers/      # Controladores (rutas)
│   │       ├── dao/              # Data Access Objects (acceso a BD)
│   │       └── models/           # Clases modelo (Alumno, Asignatura, Nota)
│   └── resources/
│       ├── templates/            # Archivos HTML
│       │   ├── index.html
│       │   └── nav/
│       │       ├── alumnos.html
│       │       ├── asignaturas.html
│       │       ├── notas.html
│       │       └── agregar-asignatura.html
│       └── application.properties
└── escuela.sql                   # Script de la base de datos
```

## Cómo ejecutar esto

### 1. Configurar la base de datos

Primero, crea la base de datos MySQL copiando el contenido de `escuela.sql` y ejecútalo en tu cliente MySQL.

### 2. Configurar las credenciales

En `src/main/java/es/dsw/connections/MySqlConnection.java`, ajusta tus datos de conexión:

```java
private String host = "localhost";
private String puerto = "3306";
private String nameDB = "escuela";
private String usuario = "root";
private String password = "1234";  // ← Cambia esto por tu contraseña
```

### 3. Abrir en el navegador

Ve a: [http://localhost:8080](http://localhost:8080)

##  Lo que he aprendido hasta ahora

- ✅ Cómo conectar Java con MySQL sin JPA (usando JDBC directo)
- ✅ Patrón DAO para separar la lógica de acceso a datos
- ✅ `@GetMapping` y `@PostMapping` para manejar rutas
- ✅ `@RequestParam` para capturar datos de formularios
- ✅ Thymeleaf para renderizar HTML dinámico (`th:each`, `th:text`, `th:href`)
- ✅ CRUD básico: INSERT, SELECT, DELETE (UPDATE pendiente)
- ✅ Bootstrap para que no se vea tan horrible

##  Funcionalidades implementadas

-  Ver lista de alumnos
-  Ver lista de asignaturas
-  Ver lista de notas (con JOIN para mostrar nombres)
-  Agregar nueva asignatura
-  Eliminar asignatura
-  Modificar asignatura (pendiente)
-  CRUD completo para alumnos (pendiente)
-  CRUD completo para notas (pendiente)


## ⚠️ Disclaimer

Este es un proyecto de **aprendizaje**, no está pensado para producción. Hay muchas cosas que se podrían mejorar (validaciones, seguridad, manejo de errores, etc.) pero el objetivo principal es **entender los conceptos básicos**.


