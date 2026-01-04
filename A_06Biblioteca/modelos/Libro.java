package A_06Biblioteca.modelos;

/**
 * Clase que representa un libro en la biblioteca. Gestiona la información del
 * libro y su estado de préstamo.
 */
public class Libro {

  // Atributos de instancia
  /** Título del libro */
  private String titulo;

  /** Autor del libro */
  private String autor;

  /**
   * Estado de préstamo del libro (true si está prestado, false si está
   * disponible)
   */
  private boolean esPrestado = false;

  /** Contador estático que registra el total de libros creados */
  private static int totalLibros;

  /**
   * Incrementa el contador total de libros. Se invoca automáticamente en el
   * constructor.
   */
  private void aumentaLibros() {
    totalLibros++;
  }

  /**
   * Constructor que inicializa un libro con título y autor. Incrementa
   * automáticamente el contador total de libros.
   * 
   * @param titulo El título del libro
   * @param autor  El autor del libro
   */
  public Libro(String titulo, String autor) {
    this.titulo = titulo;
    this.autor = autor;
    aumentaLibros();
  }

  /**
   * Marca el libro como prestado si está disponible. Si ya estaba prestado,
   * muestra un mensaje de error.
   */
  public void prestar() {

    if (esPrestado) {
      System.out.println("Lo siento, ya está prestado");
    } else {
      esPrestado = true;
      System.out.println("Libro prestado con éxito.");
    }

  }

  /**
   * Marca el libro como devuelto si estaba prestado. Si no estaba prestado,
   * muestra un mensaje de error.
   */
  public void devolver() {
    if (esPrestado) {
      esPrestado = false;
      System.out.println("Libro devuelto.");
    } else {
      System.out.println("El libro no está prestado.");
    }
  }

  /**
   * Imprime la información completa del libro incluyendo disponibilidad.
   */
  public void info() {
    System.out.println("Título: " + titulo);
    System.out.println("Autor: " + autor);
    if (esPrestado) {
      System.out.println("No está disponible.");
    } else {
      System.out.println("Está disponible.");
    }
  }

  // Getters y setters.
  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * Obtiene el total de libros creados.
   * 
   * @return El número total de instancias de Libro creadas
   */
  public static int getTotalLibros() {
    return totalLibros;
  }

  /**
   * Retorna una representación en cadena del libro. Nota: Considera si es
   * necesario mantener este método junto con info().
   */
  @Override
  public String toString() {
    return "Libro [titulo=" + titulo + ", autor=" + autor + ", esPrestado=" + esPrestado + "]";
  }

}
