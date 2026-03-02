package modelos.javabean;

/**
 * Clase que representa un envío de tipo exprés, que extiende de la clase
 * {@link Envio}.
 * Incluye información sobre si el envío requiere refrigeración.
 */
public class EnvioExpress extends Envio {

  /**
   * Indica si el envío requiere mantenimiento de la cadena de frío.
   */
  private boolean requiereFrio;

  /**
   * Construye un nuevo envío exprés con los datos especificados.
   *
   * @param idCodigo      El código identificador único del envío.
   * @param ciudadDestino La ciudad de destino del envío.
   * @param peso          El peso del envío.
   * @param requiereFrio  {@code true} si el envío requiere frío, {@code false} en
   *                      caso contrario.
   */
  public EnvioExpress(String idCodigo, String ciudadDestino, double peso, boolean requiereFrio) {
    super(idCodigo, ciudadDestino, peso);
    this.requiereFrio = requiereFrio;
  }

  /**
   * Comprueba si el envío requiere frío.
   *
   * @return {@code true} si requiere frío, {@code false} en caso contrario.
   */
  public boolean isRequiereFrio() {
    return requiereFrio;
  }

  /**
   * Establece si el envío requiere frío.
   *
   * @param requiereFrio {@code true} si requiere frío, {@code false} en caso
   *                     contrario.
   */
  public void setRequiereFrio(boolean requiereFrio) {
    this.requiereFrio = requiereFrio;
  }

  @Override
  public String toString() {
    return super.toString() + "EnvioExpress [requiereFrio=" + requiereFrio + "]";
  }

}
