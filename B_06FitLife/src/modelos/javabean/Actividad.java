package modelos.javabean;

import interfaces.IEntrenable;

/**
 * Clase abstracta base que representa una actividad física dentro del sistema
 * FitLife.
 * <p>
 * Implementa {@link IEntrenable}, por lo que todas las subclases deben definir
 * cómo calcular las calorías quemadas y cuál es su nivel de intensidad.
 * La igualdad entre actividades se determina exclusivamente por su
 * identificador {@code idActividad}.
 * </p>
 *
 * @see ClaseDirigida
 * @see EntrenamientoLibre
 */
public abstract class Actividad implements IEntrenable {

    /** Identificador único de la actividad. */
    protected String idActividad;

    /** Nombre descriptivo de la actividad. */
    protected String nombreActividad;

    /** Calorías quemadas por minuto como valor base de la actividad. */
    protected double caloriasPorMinutosBase;

    /**
     * Construye una nueva actividad con los datos básicos requeridos.
     *
     * @param idActividad            Identificador único de la actividad.
     * @param nombreActividad        Nombre descriptivo de la actividad.
     * @param caloriasPorMinutosBase Calorías base quemadas por minuto.
     */
    public Actividad(String idActividad, String nombreActividad, double caloriasPorMinutosBase) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.caloriasPorMinutosBase = caloriasPorMinutosBase;
    }

    /**
     * Devuelve el identificador único de la actividad.
     *
     * @return Identificador de la actividad.
     */
    public String getIdActividad() {
        return idActividad;
    }

    /**
     * Establece el identificador único de la actividad.
     *
     * @param idActividad Nuevo identificador de la actividad.
     */
    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * Devuelve el nombre descriptivo de la actividad.
     *
     * @return Nombre de la actividad.
     */
    public String getNombreActividad() {
        return nombreActividad;
    }

    /**
     * Establece el nombre descriptivo de la actividad.
     *
     * @param nombreActividad Nuevo nombre de la actividad.
     */
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    /**
     * Devuelve las calorías base quemadas por minuto en esta actividad.
     *
     * @return Calorías base por minuto.
     */
    public double getCaloriasPorMinutosBase() {
        return caloriasPorMinutosBase;
    }

    /**
     * Establece las calorías base quemadas por minuto en esta actividad.
     *
     * @param caloriasPorMinutosBase Nuevo valor de calorías base por minuto.
     */
    public void setCaloriasPorMinutosBase(double caloriasPorMinutosBase) {
        this.caloriasPorMinutosBase = caloriasPorMinutosBase;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idActividad == null) ? 0 : idActividad.hashCode());
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
        Actividad other = (Actividad) obj;
        if (idActividad == null) {
            if (other.idActividad != null)
                return false;
        } else if (!idActividad.equals(other.idActividad))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Actividad [idActividad=" + idActividad + ", nombreActividad=" + nombreActividad
                + ", caloriasPorMinutosBase=" + caloriasPorMinutosBase + "]";
    }

}
