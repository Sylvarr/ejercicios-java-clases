package src.modelo_javabean;

import java.util.ArrayList;

/**
 * Clase que representa un equipo de la NBA.
 * Contiene información sobre el equipo y su plantilla de jugadores.
 */
public class Equipo {

  /** Nombre del equipo */
  private String nombre;
  /** Ciudad donde juega el equipo */
  private String ciudad;
  /** Conferencia a la que pertenece (East/West) */
  private String conferencia;
  /** División a la que pertenece */
  private String division;
  /** Lista de jugadores que forman la plantilla */
  private ArrayList<Jugador> plantilla;

  /**
   * Constructor de la clase Equipo.
   * Inicializa la lista de jugadores vacía.
   *
   * @param nombre      Nombre del equipo
   * @param ciudad      Ciudad del equipo
   * @param conferencia Conferencia
   * @param division    División
   */
  public Equipo(
      String nombre,
      String ciudad,
      String conferencia,
      String division) {
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.conferencia = conferencia;
    this.division = division;
    this.plantilla = new ArrayList<>();
  }

  /**
   * Imprime por consola todos los jugadores de la plantilla.
   */
  public void imprimePlantilla() {
    for (Jugador jugador : plantilla) {
      System.out.println(jugador);
    }
  }

  /**
   * Añade un jugador a la plantilla si no está ya presente.
   *
   * @param j El jugador a fichar
   */
  public void ficharJugador(Jugador j) {
    if (!plantilla.contains(j)) {
      plantilla.add(j);
    }
  }

  /**
   * Elimina un jugador de la plantilla.
   *
   * @param j El jugador a dar de baja
   */
  public void bajaJugador(Jugador j) {
    if (plantilla.contains(j)) {
      plantilla.remove(j);
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getConferencia() {
    return conferencia;
  }

  public void setConferencia(String conferencia) {
    this.conferencia = conferencia;
  }

  public String getDivision() {
    return division;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
    Equipo other = (Equipo) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return ("Equipo [nombre=" +
        nombre +
        ", ciudad=" +
        ciudad +
        ", conferencia=" +
        conferencia +
        ", division=" +
        division +
        "]");
  }

  public ArrayList<Jugador> getPlantilla() {
    return plantilla;
  }

  public void setPlantilla(ArrayList<Jugador> plantilla) {
    this.plantilla = plantilla;
  }
}
