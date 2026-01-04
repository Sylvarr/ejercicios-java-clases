package A_06Biblioteca.modelos;

import java.util.ArrayList;

/**
 * Clase que representa una librería que gestiona un conjunto de libros.
 * Organiza los libros por categoría y permite añadir nuevos libros al
 * inventario.
 */
public class Libreria {

  /** Lista que almacena todos los libros de la librería */
  private ArrayList<Libro> listaLibros;

  /** Categoría principal de la librería */
  private String categoria;

  /**
   * Constructor que inicializa una librería con una categoría específica.
   * 
   * @param categoria La categoría de libros que gestiona esta librería
   */
  public Libreria(String categoria) {
    listaLibros = new ArrayList<Libro>();
    this.categoria = categoria;
  }

  // Getters y setters de categoria
  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  /**
   * Añade un libro a la lista de libros si no existe previamente. Imprime un
   * mensaje de confirmación o error según el resultado.
   * 
   * @param l El libro a añadir a la librería
   */
  public void addLibro(Libro l) {
    if (listaLibros.contains(l)) {
      System.out.println("El libro ya existe en la lista");
    } else {
      listaLibros.add(l);
      System.out.println("Libro añadido satisfactoriamente");
    }
  }

  // toString & hash
  @Override
  public String toString() {
    return "Libreria [listaLibros=" + listaLibros + ", categoria=" + categoria + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((listaLibros == null) ? 0 : listaLibros.hashCode());
    result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
    return result;
  }

  /**
   * Compara dos objetos Libreria basándose en su contenido. Verifica que tengan
   * la misma lista de libros y categoría.
   * 
   * @param obj El objeto a comparar
   * @return true si los objetos tienen el mismo contenido, false en caso
   *         contrario
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Libreria other = (Libreria) obj;
    if (listaLibros == null) {
      if (other.listaLibros != null)
        return false;
    } else if (!listaLibros.equals(other.listaLibros))
      return false;
    if (categoria == null) {
      if (other.categoria != null)
        return false;
    } else if (!categoria.equals(other.categoria))
      return false;
    return true;
  }

}
