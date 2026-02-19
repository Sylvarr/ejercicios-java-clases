package modelos.javabean;

import java.time.LocalDate;

import excepciones.ActividadInvalidaException;
import excepciones.FechaInvalidaException;
import excepciones.SocioInvalidoException;

/**
 * Representa una sesión de entrenamiento registrada en el sistema FitLife.
 * <p>
 * Una sesión vincula a un {@link Socio} con una {@link Actividad} concreta,
 * indicando la fecha en que se realizó y la duración en minutos. Los setters
 * de fecha, socio y actividad lanzan excepciones comprobadas si se les pasa
 * un valor {@code null}.
 * </p>
 */
public class Sesion {

  /** Fecha en la que se realizó la sesión. */
  private LocalDate fecha;

  /** Socio que realizó la sesión. */
  private Socio socio;

  /** Actividad que se realizó durante la sesión. */
  private Actividad actividadRealizada;

  /** Duración de la sesión expresada en minutos. */
  private int duracionMinutos;

  /**
   * Construye una nueva sesión de entrenamiento con todos sus datos.
   *
   * @param fecha               Fecha en la que se realizó la sesión.
   * @param socio               Socio que realizó la sesión.
   * @param actividadRealizada  Actividad llevada a cabo durante la sesión.
   * @param duracionMinutos     Duración de la sesión en minutos.
   * @throws SocioInvalidoException    Si {@code socio} es {@code null}.
   * @throws ActividadInvalidaException Si {@code actividadRealizada} es {@code null}.
   * @throws FechaInvalidaException    Si {@code fecha} es {@code null}.
   */
  public Sesion(
      LocalDate fecha,
      Socio socio,
      Actividad actividadRealizada,
      int duracionMinutos) throws SocioInvalidoException, ActividadInvalidaException, FechaInvalidaException {
    this.fecha = fecha;
    this.setSocio(socio);
    this.setActividadRealizada(actividadRealizada);
    this.setFecha(fecha);
    this.duracionMinutos = duracionMinutos;
  }

  /**
   * Devuelve la fecha en la que se realizó la sesión.
   *
   * @return Fecha de la sesión.
   */
  public LocalDate getFecha() {
    return fecha;
  }

  /**
   * Establece la fecha en la que se realizó la sesión.
   *
   * @param fecha Nueva fecha de la sesión.
   * @throws FechaInvalidaException Si {@code fecha} es {@code null}.
   */
  public void setFecha(LocalDate fecha) throws FechaInvalidaException {
    if (fecha == null) {
      throw new FechaInvalidaException("Error: la fecha debe existir.");
    } else {
      this.fecha = fecha;
    }
  }

  /**
   * Devuelve el socio que realizó la sesión.
   *
   * @return Socio de la sesión.
   */
  public Socio getSocio() {
    return socio;
  }

  /**
   * Establece el socio que realizó la sesión.
   *
   * @param socio Nuevo socio de la sesión.
   * @throws SocioInvalidoException Si {@code socio} es {@code null}.
   */
  public void setSocio(Socio socio) throws SocioInvalidoException {
    if (socio == null) {
      throw new SocioInvalidoException("Error: el socio debe existir.");
    } else {
      this.socio = socio;
    }

  }

  /**
   * Devuelve la actividad realizada durante la sesión.
   *
   * @return Actividad de la sesión.
   */
  public Actividad getActividadRealizada() {
    return actividadRealizada;
  }

  /**
   * Establece la actividad realizada durante la sesión.
   *
   * @param actividadRealizada Nueva actividad de la sesión.
   * @throws ActividadInvalidaException Si {@code actividadRealizada} es {@code null}.
   */
  public void setActividadRealizada(Actividad actividadRealizada) throws ActividadInvalidaException {
    if (actividadRealizada == null) {
      throw new ActividadInvalidaException("Error: la actividad debe existir.");
    } else {
      this.actividadRealizada = actividadRealizada;
    }
  }

  /**
   * Devuelve la duración de la sesión en minutos.
   *
   * @return Duración en minutos.
   */
  public int getDuracionMinutos() {
    return duracionMinutos;
  }

  /**
   * Establece la duración de la sesión en minutos.
   *
   * @param duracionMinutos Nueva duración en minutos.
   */
  public void setDuracionMinutos(int duracionMinutos) {
    this.duracionMinutos = duracionMinutos;
  }

  @Override
  public String toString() {
    return "Sesion [fecha=" + fecha + ", socio=" + socio.getNombre() + ", actividadRealizada="
        + actividadRealizada.getNombreActividad()
        + ", duracionMinutos=" + duracionMinutos + "]";
  }

}
