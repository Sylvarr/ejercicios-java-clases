package modelos.javabean;

/**
 * Representa a un socio registrado en el sistema FitLife.
 * <p>
 * La igualdad entre socios se determina exclusivamente por su
 * identificador {@code idSocio}.
 * </p>
 */
public class Socio {

  /** Identificador único del socio. */
  private String idSocio;

  /** Nombre completo del socio. */
  private String nombre;

  /**
   * Construye un nuevo socio con el identificador y nombre indicados.
   *
   * @param idSocio Identificador único del socio.
   * @param nombre  Nombre completo del socio.
   */
  public Socio(String idSocio, String nombre) {
    this.idSocio = idSocio;
    this.nombre = nombre;
  }

  /**
   * Devuelve el identificador único del socio.
   *
   * @return Identificador del socio.
   */
  public String getIdSocio() {
    return idSocio;
  }

  /**
   * Establece el identificador único del socio.
   *
   * @param idSocio Nuevo identificador del socio.
   */
  public void setIdSocio(String idSocio) {
    this.idSocio = idSocio;
  }

  /**
   * Devuelve el nombre completo del socio.
   *
   * @return Nombre del socio.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Establece el nombre completo del socio.
   *
   * @param nombre Nuevo nombre del socio.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idSocio == null) ? 0 : idSocio.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Socio other = (Socio) obj;
    if (idSocio == null) {
      if (other.idSocio != null)
        return false;
    } else if (!idSocio.equals(other.idSocio))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Socio [idSocio=" + idSocio + ", nombre=" + nombre + "]";
  }

}
