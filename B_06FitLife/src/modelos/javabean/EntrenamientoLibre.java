package modelos.javabean;

/**
 * Representa un entrenamiento libre realizado en una zona específica del
 * gimnasio dentro del sistema FitLife.
 * <p>
 * Extiende {@link Actividad}. Las calorías quemadas se calculan directamente
 * multiplicando las calorías base por los minutos, sin bonus adicional.
 * El nivel de intensidad es {@code "ALTO"} para la zona {@code "Crossfit"} y
 * {@code "VARIABLE"} para el resto.
 * </p>
 */
public class EntrenamientoLibre extends Actividad {

  /** Zona del gimnasio donde se realiza el entrenamiento. */
  private String zonaGimnasio;

  /**
   * Construye un nuevo entrenamiento libre con todos sus datos.
   *
   * @param idActividad            Identificador único de la actividad.
   * @param nombreActividad        Nombre descriptivo de la actividad.
   * @param caloriasPorMinutosBase Calorías base quemadas por minuto.
   * @param zonaGimnasio           Zona del gimnasio donde se realiza el entrenamiento.
   */
  public EntrenamientoLibre(
      String idActividad,
      String nombreActividad,
      double caloriasPorMinutosBase,
      String zonaGimnasio) {
    super(idActividad, nombreActividad, caloriasPorMinutosBase);
    this.zonaGimnasio = zonaGimnasio;
  }

  /**
   * Calcula las calorías quemadas multiplicando las calorías base por los
   * minutos de duración, sin ningún bonus adicional.
   *
   * @param minutos Duración del entrenamiento en minutos.
   * @return Calorías quemadas: {@code caloriasPorMinutosBase × minutos}.
   */
  @Override
  public double calcularCaloriasQuemadas(int minutos) {
    return caloriasPorMinutosBase * minutos;
  }

  /**
   * Devuelve el nivel de intensidad del entrenamiento libre.
   * <p>
   * Es {@code "ALTO"} si la zona es {@code "Crossfit"}, o {@code "VARIABLE"}
   * para cualquier otra zona.
   * </p>
   *
   * @return {@code "ALTO"} si {@code zonaGimnasio} es {@code "Crossfit"};
   *         {@code "VARIABLE"} en caso contrario.
   */
  @Override
  public String obtenerNivelIntensidad() {
    if ("Crossfit".equals(zonaGimnasio)) {
      return "ALTO";
    } else {
      return "VARIABLE";
    }
  }

  /**
   * Devuelve la zona del gimnasio donde se realiza el entrenamiento.
   *
   * @return Nombre de la zona del gimnasio.
   */
  public String getZonaGimnasio() {
    return zonaGimnasio;
  }

  /**
   * Establece la zona del gimnasio donde se realiza el entrenamiento.
   *
   * @param zonaGimnasio Nueva zona del gimnasio.
   */
  public void setZonaGimnasio(String zonaGimnasio) {
    this.zonaGimnasio = zonaGimnasio;
  }

  @Override
  public String toString() {
    return super.toString() + "EntrenamientoLibre [zonaGimnasio=" + zonaGimnasio + "]";
  }

}
