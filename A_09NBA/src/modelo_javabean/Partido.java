package src.modelo_javabean;

/**
 * Clase que representa un partido jugado entre dos equipos.
 */
public class Partido {

  /** Identificador del partido */
  private int codigo;
  /** Equipo que juega como local */
  private Equipo equipoLocal;
  /** Equipo que juega como visitante */
  private Equipo equipoVisitante;
  /** Puntos anotados por el equipo local */
  private int puntosLocal;
  /** Puntos anotados por el equipo visitante */
  private int puntosVisitante;
  /** Temporada en la que se juega el partido (ej: "2024-2025") */
  private String temporada;

  /**
   * Constructor para crear un nuevo partido con resultado.
   *
   * @param codigo          Identificador único
   * @param equipoLocal     Equipo local
   * @param equipoVisitante Equipo visitante
   * @param puntosLocal     Puntos del local
   * @param puntosVisitante Puntos del visitante
   * @param temporada       Temporada del partido
   */
  public Partido(int codigo, Equipo equipoLocal, Equipo equipoVisitante, int puntosLocal, int puntosVisitante,
      String temporada) {
    this.codigo = codigo;
    this.equipoLocal = equipoLocal;
    this.equipoVisitante = equipoVisitante;
    this.puntosLocal = puntosLocal;
    this.puntosVisitante = puntosVisitante;
    this.temporada = temporada;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Equipo getEquipoLocal() {
    return equipoLocal;
  }

  public void setEquipoLocal(Equipo equipoLocal) {
    this.equipoLocal = equipoLocal;
  }

  public Equipo getEquipoVisitante() {
    return equipoVisitante;
  }

  public void setEquipoVisitante(Equipo equipoVisitante) {
    this.equipoVisitante = equipoVisitante;
  }

  public int getPuntosLocal() {
    return puntosLocal;
  }

  public void setPuntosLocal(int puntosLocal) {
    this.puntosLocal = puntosLocal;
  }

  public int getPuntosVisitante() {
    return puntosVisitante;
  }

  public void setPuntosVisitante(int puntosVisitante) {
    this.puntosVisitante = puntosVisitante;
  }

  public String getTemporada() {
    return temporada;
  }

  public void setTemporada(String temporada) {
    this.temporada = temporada;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
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
    Partido other = (Partido) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Partido [codigo=" + codigo + ", equipoLocal=" + equipoLocal.getNombre() + ", equipoVisitante="
        + equipoVisitante.getNombre() + ", puntosLocal=" + puntosLocal + ", puntosVisitante=" + puntosVisitante
        + ", temporada=" + temporada + "]";
  }

}
