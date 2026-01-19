package src.modelo_javabean;

/**
 * Clase que almacena las estadísticas de un jugador en una temporada
 * específica.
 */
public class Estadisticas {

  /** Jugador al que pertenecen las estadísticas */
  private Jugador jugador;
  /** Temporada de las estadísticas */
  private String temporada;
  /** Promedio de puntos por partido */
  private int puntosPorPartido;
  /** Promedio de asistencias por partido */
  private int asistenciasPorPartido;
  /** Promedio de tapones por partido */
  private int taponesPorPartido;
  /** Promedio de rebotes por partido */
  private int rebotesPorPartido;

  /**
   * Constructor para inicializar estadísticas.
   *
   * @param jugador               Jugador
   * @param temporada             Temporada
   * @param puntosPorPartido      Media de puntos
   * @param asistenciasPorPartido Media de asistencias
   * @param taponesPorPartido     Media de tapones
   * @param rebotesPorPartido     Media de rebotes
   */
  public Estadisticas(
      Jugador jugador,
      String temporada,
      int puntosPorPartido,
      int asistenciasPorPartido,
      int taponesPorPartido,
      int rebotesPorPartido) {
    this.jugador = jugador;
    this.temporada = temporada;
    this.puntosPorPartido = puntosPorPartido;
    this.asistenciasPorPartido = asistenciasPorPartido;
    this.taponesPorPartido = taponesPorPartido;
    this.rebotesPorPartido = rebotesPorPartido;
  }

  public Jugador getJugador() {
    return jugador;
  }

  public void setJugador(Jugador jugador) {
    this.jugador = jugador;
  }

  public String getTemporada() {
    return temporada;
  }

  public void setTemporada(String temporada) {
    this.temporada = temporada;
  }

  public int getPuntosPorPartido() {
    return puntosPorPartido;
  }

  public void setPuntosPorPartido(int puntosPorPartido) {
    this.puntosPorPartido = puntosPorPartido;
  }

  public int getAsistenciasPorPartido() {
    return asistenciasPorPartido;
  }

  public void setAsistenciasPorPartido(int asistenciasPorPartido) {
    this.asistenciasPorPartido = asistenciasPorPartido;
  }

  public int getTaponesPorPartido() {
    return taponesPorPartido;
  }

  public void setTaponesPorPartido(int taponesPorPartido) {
    this.taponesPorPartido = taponesPorPartido;
  }

  public int getRebotesPorPartido() {
    return rebotesPorPartido;
  }

  public void setRebotesPorPartido(int rebotesPorPartido) {
    this.rebotesPorPartido = rebotesPorPartido;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((jugador == null) ? 0 : jugador.hashCode());
    result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
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
    Estadisticas other = (Estadisticas) obj;
    if (jugador == null) {
      if (other.jugador != null)
        return false;
    } else if (!jugador.equals(other.jugador))
      return false;
    if (temporada == null) {
      if (other.temporada != null)
        return false;
    } else if (!temporada.equals(other.temporada))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return ("Estadisticas [jugador=" + jugador.getNombre() + ", temporada=" + temporada + ", puntosPorPartido="
        + puntosPorPartido + ", asistenciasPorPartido=" + asistenciasPorPartido + ", taponesPorPartido="
        + taponesPorPartido + ", rebotesPorPartido=" + rebotesPorPartido + "]");
  }
}