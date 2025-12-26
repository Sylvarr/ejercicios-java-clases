package A_03AcademiaDeNotas.modelos;

public class Estudiante {

  // Atributos
  private String nombre;
  private double nota;
  private int id;
  // Con static inicializamos una variable que pertenece a la clase misma
  private static int contador = 1;

  // Constructor
  public Estudiante(String nombre, double nota) {
    this.nombre = nombre;
    this.nota = nota;
    // Asignamos el valor actual del contador como id de cada estudiante
    this.id = contador;
    // Aumentamos el contador en 1
    contador++;
  }

  // Getters y Setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getNota() {
    return nota;
  }

  public void setNota(double nota) {
    this.nota = nota;
  }

  public int getId() {
    return id;
  }

  // toString
  @Override
  public String toString() {
    return "Estudiante [nombre=" + nombre + ", nota=" + nota + ", id=" + id + "]";
  }

}
