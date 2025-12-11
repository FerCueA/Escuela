-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS escuela CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE escuela;

-- Tabla de estudiantes (nombre y apellidos)
CREATE TABLE estudiantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL
) ENGINE=InnoDB;

-- Tabla de asignaturas
CREATE TABLE asignaturas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
) ENGINE=InnoDB;

-- Tabla de relación con notas (relaciona estudiante con asignatura mediante IDs)
CREATE TABLE notas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estudiante_id BIGINT NOT NULL,
    asignatura_id BIGINT NOT NULL,
    calificacion DECIMAL(4,2) NOT NULL,
    FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id) ON DELETE CASCADE,
    FOREIGN KEY (asignatura_id) REFERENCES asignaturas(id) ON DELETE CASCADE,
    UNIQUE KEY unique_estudiante_asignatura (estudiante_id, asignatura_id)
) ENGINE=InnoDB;

-- Datos de ejemplo (opcional)
INSERT INTO estudiantes (nombre, apellidos) VALUES
('Juan', 'García Pérez'),
('María', 'López Martínez'),
('Carlos', 'Sánchez Rodríguez');

INSERT INTO asignaturas (nombre, descripcion) VALUES
('Matemáticas', 'Álgebra y cálculo'),
('Historia', 'Historia contemporánea'),
('Programación', 'Desarrollo de software');

INSERT INTO notas (estudiante_id, asignatura_id, calificacion) VALUES
(1, 1, 8.5),
(1, 2, 7.0),
(2, 1, 9.0),
(2, 3, 8.0),
(3, 2, 6.5),
(3, 3, 9.5);