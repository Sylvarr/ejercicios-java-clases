package modelos.javabean;

/**
 * Clase que representa un envío de tipo estándar, que extiende de la clase
 * {@link Envio}.
 * Incluye información sobre los días estimados de entrega.
 */
public class EnvioEstandar extends Envio {

  /**
   * Los días estimados que tardará el envío en llegar a su destino.
   */
  private int diasEstimados;

  /**
   * Construye un nuevo envío estándar con los datos especificados.
   *
   * @param idCodigo      El código identificador único del envío.
   * @param ciudadDestino La ciudad de destino del envío.
   * @param peso          El peso del envío.
   * @param diasEstimados Los días estimados para la entrega.
   */
  public EnvioEstandar(String idCodigo, String ciudadDestino, double peso, int diasEstimados) {
    super(idCodigo, ciudadDestino, peso);
    this.diasEstimados = diasEstimados;
  }

  /**
   * Obtiene los días estimados de entrega.
   *
   * @return Los días estimados.
   */
  public int getDiasEstimados() {
    return diasEstimados;
  }

  /**
   * Establece los días estimados de entrega.
   *
   * @param diasEstimados Los nuevos días estimados.
   */
  public void setDiasEstimados(int diasEstimados) {
    this.diasEstimados = diasEstimados;
  }

  @Override
  public String toString() {
    return super.toString() + "EnvioEstandar [diasEstimados=" + diasEstimados + "]";
  }

}
