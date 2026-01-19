package src.modelo_negocio;

import java.util.ArrayList;

import src.modelo_javabean.Equipo;
import src.modelo_javabean.Estadisticas;
import src.modelo_javabean.Jugador;
import src.modelo_javabean.Partido;

/**
 * Calse encargada de la Lógica de Negocio.
 * Gestiona las listas de equipos, jugadores, partidos y estadísticas.
 * Realiza las operaciones CRUD (Create, Read, Update, Delete) principales.
 */
public class GestionNBA {

  private ArrayList<Jugador> jugadores;
  private ArrayList<Equipo> equipos;
  private ArrayList<Partido> partidos;
  private ArrayList<Estadisticas> estadisticas;

  /**
   * Constructor que inicializa todas las listas de almacenamiento vacías.
   */
  public GestionNBA() {
    this.jugadores = new ArrayList<>();
    this.equipos = new ArrayList<>();
    this.partidos = new ArrayList<>();
    this.estadisticas = new ArrayList<>();
  }

  /**
   * Busca un equipo por su nombre.
   *
   * @param nombre Nombre del equipo a buscar
   * @return El objeto Equipo si existe, null si no
   */
  public Equipo buscarEquipo(String nombre) {
    for (Equipo equipo : equipos) {
      if (equipo.getNombre().equals(nombre)) {
        return equipo;
      }
    }

    return null;
  }

  /**
   * Busca un jugador por su código único.
   *
   * @param codigo Código del jugador
   * @return El objeto Jugador si existe, null si no
   */
  public Jugador buscarIdJugador(int codigo) {
    for (Jugador jugador : jugadores) {
      if (jugador.getCodigo() == codigo) {
        return jugador;
      }
    }

    return null;
  }

  /**
   * Busca un partido por su código.
   * Método privado interno.
   *
   * @param codigo Código del partido
   * @return El objeto Partido si existe, null si no
   */
  private Partido buscarPartido(int codigo) {
    for (Partido partido : partidos) {
      if (partido.getCodigo() == codigo) {
        return partido;
      }
    }

    return null;
  }

  /**
   * Da de alta un nuevo equipo en el sistema.
   *
   * @param nombre      Nombre del equipo (debe ser único)
   * @param ciudad      Ciudad
   * @param conferencia Conferencia
   * @param Division    División
   * @return true si se crea correctamente, false si ya existe un equipo con ese
   *         nombre
   */
  public boolean altaEquipo(
      String nombre,
      String ciudad,
      String conferencia,
      String Division) {
    if (buscarEquipo(nombre) != null) {
      return false;
    }

    Equipo nuevo = new Equipo(
        nombre,
        ciudad,
        conferencia,
        Division);

    equipos.add(nuevo);
    return true;
  }

  /**
   * Da de baja un equipo.
   * Solo permite borrar si el equipo no tiene jugadores asignados.
   *
   * @param nombre Nombre del equipo a borrar
   * @return true si se borra, false si no existe o tiene jugadores
   */
  public boolean bajaEquipo(String nombre) {
    Equipo equipo = buscarEquipo(nombre);

    if (equipo == null) {
      return false;
    }

    if (equipo.getPlantilla().size() > 0) {
      return false;
    }

    equipos.remove(equipo);
    return true;
  }

  /**
   * Da de alta un nuevo jugador y lo asigna a un equipo existente.
   *
   * @param codigo       Código único
   * @param nombre       Nombre
   * @param procedencia  Procedencia
   * @param altura       Altura
   * @param peso         Peso
   * @param posicion     Posición
   * @param nombreEquipo Nombre del equipo al que pertenecerá
   * @return true si se crea correctamente, false si el código ya existe o el
   *         equipo no se encuentra
   */
  public boolean altaJugador(
      int codigo,
      String nombre,
      String procedencia,
      double altura,
      int peso,
      String posicion,
      String nombreEquipo) {
    Equipo equipoEncontrado = buscarEquipo(nombreEquipo);

    if (buscarIdJugador(codigo) != null) {
      return false;
    }

    if (equipoEncontrado == null) {
      return false;
    }

    Jugador nuevo = new Jugador(
        codigo,
        nombre,
        procedencia,
        altura,
        peso,
        posicion,
        equipoEncontrado);

    jugadores.add(nuevo);
    equipoEncontrado.ficharJugador(nuevo);
    return true;
  }

  /**
   * Da de baja un jugador del sistema y de su equipo.
   *
   * @param codigo Código del jugador a borrar
   * @return true si se borra correctamente, false si no existe
   */
  public boolean bajaJugador(int codigo) {

    Jugador jugadorEncontrado = buscarIdJugador(codigo);

    if (jugadorEncontrado == null) {
      return false;
    }

    Equipo equipoDelJugador = jugadorEncontrado.getEquipo();
    jugadores.remove(jugadorEncontrado);
    if (equipoDelJugador != null) {
      equipoDelJugador.bajaJugador(jugadorEncontrado);
    }

    return true;
  }

  /**
   * Registra un nuevo partido entre dos equipos existentes.
   *
   * @param codigo          Código del partido
   * @param equipoLocal     Nombre equipo local
   * @param equipoVisitante Nombre equipo visitante
   * @param puntosLocal     Puntos local
   * @param puntosVisitante Puntos visitante
   * @param temporada       Temporada
   * @return true si se registra, false si algún equipo no existe, es el mismo
   *         equipo, o el código está repetido
   */
  public boolean altaPartido(
      int codigo,
      String equipoLocal,
      String equipoVisitante,
      int puntosLocal,
      int puntosVisitante,
      String temporada) {

    Equipo equipoLocalEncontrado = buscarEquipo(equipoLocal);
    Equipo equipoVisitanteEncontrado = buscarEquipo(equipoVisitante);

    if (buscarPartido(codigo) != null) {
      return false;
    }

    if (equipoLocalEncontrado == null || equipoVisitanteEncontrado == null) {
      return false;
    }

    if (equipoLocalEncontrado.equals(equipoVisitanteEncontrado)) {
      return false;
    }

    Partido nuevo = new Partido(
        codigo,
        equipoLocalEncontrado,
        equipoVisitanteEncontrado,
        puntosLocal,
        puntosVisitante,
        temporada);
    partidos.add(nuevo);

    return true;
  }

  public boolean bajaPartido(int codigo) {

    Partido partidoEncontrado = buscarPartido(codigo);

    if (partidoEncontrado == null) {
      return false;
    }

    partidos.remove(partidoEncontrado);

    return true;
  }

  /**
   * Registra estadísticas para un jugador.
   *
   * @param codigo                Código del jugador
   * @param temporada             Temporada
   * @param puntosPorPartido      Stats puntos
   * @param asistenciasPorPartido Stats asistencias
   * @param taponesPorPartido     Stats tapones
   * @param rebotesPorPartido     Stats rebotes
   * @return true si se añade, false si el jugador no existe o la estadística ya
   *         existe
   */
  public boolean altaEstadistica(
      int codigo,
      String temporada,
      int puntosPorPartido,
      int asistenciasPorPartido,
      int taponesPorPartido,
      int rebotesPorPartido) {

    Jugador jugador = buscarIdJugador(codigo);
    if (jugador == null) {
      return false;
    }

    Estadisticas nueva = new Estadisticas(
        jugador,
        temporada,
        puntosPorPartido,
        asistenciasPorPartido,
        taponesPorPartido,
        rebotesPorPartido);

    if (estadisticas.contains(nueva)) {
      return false;
    }

    estadisticas.add(nueva);

    return true;
  }

  public void mostrarNombresEquipos() {
    System.out.println("--- Equipos Disponibles ---");
    if (equipos.isEmpty()) {
      System.out.println("(No hay equipos registrados)");
      return;
    }
    for (Equipo e : equipos) {
      System.out.println("- " + e.getNombre());
    }
  }

  public boolean hayEquipos() {
    return !equipos.isEmpty();
  }

  public void mostrarNombresJugadores(String nombreEquipo) {

    Equipo equipoEncontrado = buscarEquipo(nombreEquipo);

    if (equipoEncontrado == null) {
      System.out.println("El equipo no existe.");
      return;
    }

    System.out.println("--- Jugadores de los " + equipoEncontrado.getNombre() + " ---");

    for (Jugador j : equipoEncontrado.getPlantilla()) {
      System.out.println(j.getCodigo() + " - " + j.getNombre());
    }

  }

  /**
   * Muestra por consola los equipos que no tienen jugadores (vacíos).
   *
   * @return true si hay al menos un equipo vacío, false si no hay ninguno.
   */
  public boolean mostrarEquiposVacios() {
    boolean hayVacios = false;
    System.out.println("--- Equipos Vacíos (Disponibles para borrar) ---");
    for (Equipo e : equipos) {
      if (e.getPlantilla().isEmpty()) {
        System.out.println("- " + e.getNombre());
        hayVacios = true;
      }
    }
    if (!hayVacios) {
      System.out.println("(No hay equipos vacíos)");
    }
    return hayVacios;
  }
}
