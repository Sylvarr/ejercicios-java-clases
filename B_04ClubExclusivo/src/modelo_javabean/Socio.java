package modelo_javabean;

/**
 * Representa a un socio del club con su nombre como identificador.
 * <p>
 * Dos socios se consideran iguales si tienen el mismo nombre,
 * lo que permite evitar duplicados al usar colecciones basadas en {@code hashCode}
 * y {@code equals} como {@link java.util.HashSet}.
 * </p>
 *
 * @author pencho
 */
public class Socio {

  /** Nombre del socio. */
  private String nombre;

  /**
   * Crea un nuevo socio con el nombre indicado.
   *
   * @param nombre el nombre del socio
   */
  public Socio(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Devuelve el nombre del socio.
   *
   * @return el nombre del socio
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Establece el nombre del socio.
   *
   * @param nombre el nuevo nombre del socio
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Socio [nombre=" + nombre + "]";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Socio other = (Socio) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }

}
