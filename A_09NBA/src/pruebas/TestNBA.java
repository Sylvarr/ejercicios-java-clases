package src.pruebas;

import src.modelo_negocio.GestionNBA;

/**
 * Clase de pruebas para verificar la lógica de negocio sin interfaz gráfica.
 * Ejecuta una serie de operaciones automáticas para comprobar el correcto
 * funcionamiento.
 */
public class TestNBA {

  /**
   * Metodo main de pruebas.
   *
   * @param args Argumentos de linea de comandos.
   */
  public static void main(String[] args) {

    GestionNBA gestion = new GestionNBA();

    // Alta Equipos
    System.out.println("Alta Lakers: " + gestion.altaEquipo("Lakers", "Los Angeles", "Western", "Pacific"));
    System.out.println("Alta Celtics: " + gestion.altaEquipo("Celtics", "Boston", "Eastern", "Atlantic"));

    // Alta Jugadores
    System.out.println(
        "Alta LeBron (23): " + gestion.altaJugador(23, "LeBron James", "USA", 2.06, 113, "Alero", "Lakers"));

    // Intento de duplicado para probar validación
    System.out.println(
        "Alta LeBron2 (23): " + gestion.altaJugador(23, "LeBron James", "USA", 2.06, 113, "Alero", "Lakers"));

    System.out.println(
        "Alta Tatum (0): " + gestion.altaJugador(0, "Jayson Tatum", "USA", 2.03, 95, "Alero", "Celtics"));

    System.out.println("Alta Partido Celtics vs Lakers: "
        + gestion.altaPartido(1, "Lakers", "Celtics", 112, 105, "2024-2025"));

    System.out.println("Alta partido Fantasma: " + gestion.altaPartido(2, "Bulls", "Lakers", 110, 108, "2024-2025"));

    System.out.println("Baja equipo con jugador dentro: " + gestion.bajaEquipo("Lakers"));

    System.out.println("Borrado de jugador: " + gestion.bajaJugador(23));

    System.out.println("Baja equipo sin jugadores dentro: " + gestion.bajaEquipo("Lakers"));

  }

}
