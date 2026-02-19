package interfaces;

/**
 * Interfaz que define el comportamiento de cualquier actividad entrenable
 * dentro del sistema FitLife.
 * <p>
 * Toda actividad que implemente esta interfaz debe ser capaz de calcular
 * las calorías quemadas en función de su duración y de informar sobre
 * su nivel de intensidad.
 * </p>
 */
public interface IEntrenable {

    /**
     * Calcula las calorías quemadas durante la actividad en función de
     * los minutos de duración.
     *
     * @param minutos Duración de la actividad en minutos.
     * @return Número de calorías quemadas.
     */
    double calcularCaloriasQuemadas(int minutos);

    /**
     * Devuelve el nivel de intensidad de la actividad.
     *
     * @return Cadena con el nivel de intensidad (por ejemplo, {@code "ALTO"},
     *         {@code "MEDIO"} o {@code "VARIABLE"}).
     */
    String obtenerNivelIntensidad();
}
