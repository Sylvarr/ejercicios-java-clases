package modelos.javabean;

/**
 * Representa una clase dirigida por un profesor dentro del sistema FitLife.
 * <p>
 * Extiende {@link Actividad} añadiendo el nombre del profesor responsable y un
 * indicador de si la clase requiere reserva previa. Las calorías quemadas
 * incorporan un bonus fijo de 50 kcal por la motivación grupal. El nivel de
 * intensidad es {@code "ALTO"} cuando la clase requiere reserva y
 * {@code "MEDIO"} en caso contrario.
 * </p>
 */
public class ClaseDirigida extends Actividad {

  /** Nombre del profesor que imparte la clase. */
  private String nombreProfesor;

  /** Indica si la clase requiere reserva previa para poder asistir. */
  private boolean requiereReserva;

  /**
   * Construye una nueva clase dirigida con todos sus datos.
   *
   * @param idActividad            Identificador único de la actividad.
   * @param nombreActividad        Nombre descriptivo de la actividad.
   * @param caloriasPorMinutosBase Calorías base quemadas por minuto.
   * @param nombreProfesor         Nombre del profesor que imparte la clase.
   * @param requiereReserva        {@code true} si la clase requiere reserva previa.
   */
  public ClaseDirigida(
      String idActividad,
      String nombreActividad,
      double caloriasPorMinutosBase,
      String nombreProfesor,
      boolean requiereReserva) {
    super(idActividad, nombreActividad, caloriasPorMinutosBase);
    this.nombreProfesor = nombreProfesor;
    this.requiereReserva = requiereReserva;
  }

  /**
   * Calcula las calorías quemadas aplicando un bonus fijo de 50 kcal
   * sobre el valor base multiplicado por los minutos de duración.
   *
   * @param minutos Duración de la clase en minutos.
   * @return Calorías quemadas: {@code (caloriasPorMinutosBase × minutos) + 50}.
   */
  @Override
  public double calcularCaloriasQuemadas(int minutos) {
    return (caloriasPorMinutosBase * minutos) + 50;
  }

  /**
   * Devuelve el nivel de intensidad de la clase dirigida.
   * <p>
   * Es {@code "ALTO"} si la clase requiere reserva previa, o {@code "MEDIO"}
   * en caso contrario.
   * </p>
   *
   * @return {@code "ALTO"} o {@code "MEDIO"} según {@code requiereReserva}.
   */
  @Override
  public String obtenerNivelIntensidad() {
    if (requiereReserva) {
      return "ALTO";
    } else {
      return "MEDIO";
    }
  }

  /**
   * Devuelve el nombre del profesor que imparte la clase.
   *
   * @return Nombre del profesor.
   */
  public String getNombreProfesor() {
    return nombreProfesor;
  }

  /**
   * Establece el nombre del profesor que imparte la clase.
   *
   * @param nombreProfesor Nuevo nombre del profesor.
   */
  public void setNombreProfesor(String nombreProfesor) {
    this.nombreProfesor = nombreProfesor;
  }

  /**
   * Indica si la clase requiere reserva previa para poder asistir.
   *
   * @return {@code true} si requiere reserva; {@code false} en caso contrario.
   */
  public boolean isRequiereReserva() {
    return requiereReserva;
  }

  /**
   * Establece si la clase requiere reserva previa.
   *
   * @param requiereReserva {@code true} para exigir reserva previa.
   */
  public void setRequiereReserva(boolean requiereReserva) {
    this.requiereReserva = requiereReserva;
  }

  @Override
  public String toString() {
    return super.toString() + "ClaseDirigida [nombreProfesor=" + nombreProfesor + ", requiereReserva=" + requiereReserva
        + "]";
  }

}
