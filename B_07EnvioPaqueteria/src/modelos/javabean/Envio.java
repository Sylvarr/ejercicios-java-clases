package modelos.javabean;

/**
 * Clase abstracta que representa un envío genérico en el sistema.
 * Sirve como base para tipos específicos de envíos.
 */
public abstract class Envio {

  /**
   * El código identificador único del envío.
   */
  protected String idCodigo;

  /**
   * La ciudad de destino del envío.
   */
  protected String ciudadDestino;

  /**
   * El peso del envío en gramos o kilogramos (según la convención del sistema).
   */
  protected double peso;

  /**
   * Construye un nuevo envío con los datos especificados.
   *
   * @param idCodigo      El código identificador único del envío.
   * @param ciudadDestino La ciudad de destino del envío.
   * @param peso          El peso del envío.
   */
  public Envio(String idCodigo, String ciudadDestino, double peso) {
    this.idCodigo = idCodigo;
    this.ciudadDestino = ciudadDestino;
    this.peso = peso;
  }

  /**
   * Obtiene el código identificador del envío.
   *
   * @return El código identificador.
   */
  public String getIdCodigo() {
    return idCodigo;
  }

  /**
   * Establece el código identificador del envío.
   *
   * @param idCodigo El nuevo código identificador.
   */
  public void setIdCodigo(String idCodigo) {
    this.idCodigo = idCodigo;
  }

  /**
   * Obtiene la ciudad de destino del envío.
   *
   * @return La ciudad de destino.
   */
  public String getCiudadDestino() {
    return ciudadDestino;
  }

  /**
   * Establece la ciudad de destino del envío.
   *
   * @param ciudadDestino La nueva ciudad de destino.
   */
  public void setCiudadDestino(String ciudadDestino) {
    this.ciudadDestino = ciudadDestino;
  }

  /**
   * Obtiene el peso del envío.
   *
   * @return El peso del envío.
   */
  public double getPeso() {
    return peso;
  }

  /**
   * Establece el peso del envío.
   *
   * @param peso El nuevo peso del envío.
   */
  public void setPeso(double peso) {
    this.peso = peso;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idCodigo == null) ? 0 : idCodigo.hashCode());
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
    Envio other = (Envio) obj;
    if (idCodigo == null) {
      if (other.idCodigo != null)
        return false;
    } else if (!idCodigo.equals(other.idCodigo))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Envio [idCodigo=" + idCodigo + ", ciudadDestino=" + ciudadDestino + ", peso=" + peso + "]";
  }

}
