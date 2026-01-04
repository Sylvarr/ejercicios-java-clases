package A_06Biblioteca.pruebas;

import A_06Biblioteca.modelos.Libreria;
import A_06Biblioteca.modelos.Libro;

/**
 * Clase de prueba para verificar la funcionalidad del sistema de biblioteca.
 * Prueba la creación de libros, la gestión de una librería y el
 * préstamo/devolución de libros.
 */
public class TestBiblioteca {

  /**
   * Método principal que ejecuta las pruebas del sistema.
   * 
   * @param args Argumentos de línea de comandos (no utilizados)
   */
  public static void main(String[] args) {

    // Crear instancias de libros
    Libro elQuijote = new Libro("El Quijote", "Cervantes");
    Libro harryPotter = new Libro("Harry Potter", "J.K. Rowling");

    // Crear una librería de categoría Fantasy y añadir libros
    Libreria libreria = new Libreria("Fantasy");
    libreria.addLibro(elQuijote);
    libreria.addLibro(elQuijote); // Intenta añadir el mismo libro nuevamente

    // Mostrar el total de libros creados
    System.out.println(Libro.getTotalLibros());

    // Probar el sistema de préstamo y devolución
    harryPotter.prestar();
    harryPotter.prestar(); // Intenta prestar un libro ya prestado
    harryPotter.devolver();
  }
}
