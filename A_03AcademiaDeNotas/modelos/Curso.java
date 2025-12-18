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
    // Necesitamos guardar la suma de todas las notas
    double sumaTotal = 0;

    // Ya que es posible que la lista este vacia, contemplamos tal caso
    // isEmpty es un método de arrayList que nos devuelve un booleano de si esta
    // vacia o no
    if (this.listaAlumnos.isEmpty()) {
      return 0;
    }

    // Iteramos sobre listaAlumnos y guardamos cada estudiante en la variable "e"
    for (Estudiante e : this.listaAlumnos) {
      sumaTotal += e.getNota();
    }

    // size() es tambien un método de ArrayList que nos devuelve el número de items
    // En este caso dividimos el total de notas que hemos conseguido con el for,
    // entre el número total
    // de notas
    return sumaTotal / this.listaAlumnos.size();
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
