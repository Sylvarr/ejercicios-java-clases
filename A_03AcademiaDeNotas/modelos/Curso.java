package A_03AcademiaDeNotas.modelos;

import java.util.ArrayList;

public class Curso {

  // Atributos
  private String nombre;
  private ArrayList<Estudiante> listaAlumnos;

  // Métodos propios
  // Función para agregar un alumno nuevo al ArrayList
  public void agregarAlumno(Estudiante e) {
    this.listaAlumnos.add(e);
  }

  // Función para imprimir la lista de alumnos
  public void mostrarClase() {

    for (Estudiante e : this.listaAlumnos) {
      System.out.println(e);
    }
  }

  // Función para calcular la nota media
  public double calcularMedia() {

    // Para calcular la nota media hace falta sumar todas las notas
    // Y tambien hace falta dividir la suma entre el total de notas
    // Para ello declaramos una nota y un contador.
    double nota = 0;
    double contador = 0;

    // Recorremos la lista de alumnos
    for (Estudiante e : this.listaAlumnos) {
      // En cada iteracion sumamos la nota actual al total
      // También aumentamos el contador en 1
      nota += e.getNota();
      contador += 1;
    }

    // Calculamos y devolvemos la nota media
    double notaMedia = nota / contador;
    return notaMedia;

  }

  // Si un alumno tiene una nota menor a 5, se la cambiamos a 5.
  public void aprobadoGeneral() {

    for (Estudiante e : this.listaAlumnos) {

      if (e.getNota() < 5) {
        e.setNota(5);
      }

    }

  }

  // Constructor - inicializamos ArrayList vacio al construir un objeto
  public Curso(String nombre) {
    this.nombre = nombre;
    this.listaAlumnos = new ArrayList<Estudiante>();
  }

  // Getters y setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ArrayList<Estudiante> getListaAlumnos() {
    return listaAlumnos;
  }

  public void setListaAlumnos(ArrayList<Estudiante> listaAlumnos) {
    this.listaAlumnos = listaAlumnos;
  }

  // toString
  @Override
  public String toString() {
    return "Curso [nombre=" + nombre + ", listaAlumnos=" + listaAlumnos + "]";
  }

}
