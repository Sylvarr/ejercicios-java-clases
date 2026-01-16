package src.modelo_javabean;

/**
 * Clase que representa a un jugador de baloncesto.
 */
public class Jugador {

  /** Identificador único del jugador (dorsal o id) */
  private int codigo;
  /** Nombre completo del jugador */
  private String nombre;
  /** Lugar de procedencia (país, universidad, etc.) */
  private String procedencia;
  /** Altura en metros */
  private double altura;
  /** Peso en kilogramos */
  private int peso;
  /** Posición en el campo (Base, Alero, Pivot, etc.) */
  private String posicion;
  /** Equipo al que pertenece actualmente */
  private Equipo equipo;

  /**
   * Constructor completo para crear un jugador.
   *
   * @param codigo      Código identificador
   * @param nombre      Nombre del jugador
   * @param procedencia Procedencia
   * @param altura      Altura en m
   * @param peso        Peso en kg
   * @param posicion    Posición de juego
   * @param equipo      Equipo al que pertenece
   */
  public Jugador(int codigo, String nombre, String procedencia, double altura, int peso, String posicion,
      Equipo equipo) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.procedencia = procedencia;
    this.altura = altura;
    this.peso = peso;
    this.posicion = posicion;
    this.equipo = equipo;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getProcedencia() {
    return procedencia;
  }

  public void setProcedencia(String procedencia) {
    this.procedencia = procedencia;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public String getPosicion() {
    return posicion;
  }

  public void setPosicion(String posicion) {
    this.posicion = posicion;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
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
    Jugador other = (Jugador) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Jugador [codigo=" + codigo + ", nombre=" + nombre + ", procedencia=" + procedencia + ", altura=" + altura
        + ", peso=" + peso + ", posicion=" + posicion + ", equipo=" + equipo.getNombre() + "]";
  }

}