package A_03AcademiaDeNotas.pruebas;

import A_03AcademiaDeNotas.modelos.Curso;
import A_03AcademiaDeNotas.modelos.Estudiante;

public class TestAcademia {

  public static void main(String[] args) {

    // Creamos un nuevo curso
    Curso cursoJava = new Curso("Java Avanzado");

    // Creamos 3 alumnos
    Estudiante javier = new Estudiante("Javier", 3);
    Estudiante paco = new Estudiante("Francisco", 9);
    Estudiante jorge = new Estudiante("Jorge", 5);

    // Agregamos los 3 alumnos al curso
    cursoJava.agregarAlumno(javier);
    cursoJava.agregarAlumno(paco);
    cursoJava.agregarAlumno(jorge);

    // Mostramos los datos de los estudiantes del curso
    System.out.println("Las notas reales son:");
    cursoJava.mostrarClase();

    // Si tenemos un alumnos suspendido, lo aprobamos automaticamente
    cursoJava.aprobadoGeneral();

    // Mostramos la lista tras el aprobado general
    System.out.println("Las notas tras el aprobado general: ");
    cursoJava.mostrarClase();

    // Calculamos la media de todas las notas, incluidas las corregidas
    System.out.println(cursoJava.calcularMedia());

    Estudiante pencho = new Estudiante("Pencho", 10);
    Estudiante nathaly = new Estudiante("Nathaly", 10);

    System.out.println("Info Pencho: " + pencho);
    System.out.println("Info Nathaly: " + nathaly);

  }

}
