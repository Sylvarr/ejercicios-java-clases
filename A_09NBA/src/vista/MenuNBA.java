package src.vista;

import java.util.Scanner;

import src.modelo_negocio.GestionNBA;

/**
 * Calse principal de la Vista (Interfaz de Usuario).
 * Muestra un menú de texto para interactuar con la gestión de la NBA.
 * Utiliza Scanner para leer la entrada del usuario.
 */
public class MenuNBA {

  static Scanner sc = new Scanner(System.in);
  static GestionNBA gestion = new GestionNBA();

  /**
   * Método principal que ejecuta la aplicación.
   * Contiene el bucle del menú principal.
   *
   * @param args Argumentos de la línea de comandos (no utilizados)
   */
  public static void main(String[] args) {

    int opcion = 0;

    do {
      System.out.println("\n---  GESTIÓN NBA  ---");
      System.out.println("1. Alta Equipo");
      System.out.println("2. Alta Jugador");
      System.out.println("3. Baja Equipo");
      System.out.println("4. Baja Jugador");
      System.out.println("5. Listar Jugadores");
      System.out.println("6. Salir");
      System.out.print("Elige una opción: ");

      opcion = sc.nextInt();
      sc.nextLine();

      switch (opcion) {
        case 1:
          System.out.println("Has elegido Alta Equipo...");
          addEquipo();
          break;
        case 2:
          System.out.println("Has elegido Alta Jugador...");
          addJugador();
          break;
        case 3:
          System.out.println("Has elegido Baja Equipo...");
          bajaEquipo();
          break;
        case 4:
          System.out.println("Has elegido Baja Jugador...");
          bajaJugador();
          break;
        case 5:
          System.out.println("Has elegido Listar Jugadores...");
          listarJugadores();
          break;
        case 6:
          System.out.println("Adios!");
          break;
        default:
          System.out.println("Por favor elige una opción válida.");
          break;
      }

    } while (opcion != 6);

  }

  /**
   * Solicita datos al usuario y llama a la lógica para añadir un equipo.
   */
  private static void addEquipo() {
    System.out.println("\n--- ALTA DE EQUIPO ---");

    System.out.print("Nombre: ");
    String nombre = sc.nextLine().trim();

    System.out.print("Ciudad: ");
    String ciudad = sc.nextLine().trim();

    System.out.print("Conferencia: ");
    String conferencia = sc.nextLine().trim();

    System.out.print("División: ");
    String division = sc.nextLine().trim();

    boolean exito = gestion.altaEquipo(nombre, ciudad, conferencia, division);

    if (exito) {
      System.out.println("Equipo guardado con éxito!");
      System.out.println("Ficha creada: " + gestion.buscarEquipo(nombre));
    } else {
      System.out.println("Error: No se pudo crear.");
    }
  }

  /**
   * Solicita datos al usuario y llama a la lógica para fichar un jugador.
   * Muestra la lista de equipos disponibles para elegir.
   */
  private static void addJugador() {
    System.out.println("\n --- ALTA DE JUGADOR ---");

    if (!gestion.hayEquipos()) {
      System.out.println("Error: No hay equipos registrados para fichar jugadores.");
      System.out.println("   -> Registra un equipo primero (Opción 1).");
      return;
    }

    System.out.print("Codigo: ");
    int codigo = sc.nextInt();
    sc.nextLine();

    System.out.print("Nombre: ");
    String nombre = sc.nextLine();

    System.out.print("Procedencia: ");
    String procedencia = sc.nextLine();

    System.out.print("Altura (con comas, ej: 2,05): ");
    double altura = sc.nextDouble();

    System.out.print("Peso: ");
    int peso = sc.nextInt();
    sc.nextLine();

    System.out.print("Posicion: ");
    String posicion = sc.nextLine();

    System.out.println("A qué equipo pertenece el jugador? Elige uno de la lista:");

    gestion.mostrarNombresEquipos();

    System.out.print("Escribe el nombre exacto del equipo: ");
    String nombreEquipo = sc.nextLine();

    // --- EL MOMENTO DE LA VERDAD ---
    boolean exito = gestion.altaJugador(
        codigo,
        nombre,
        procedencia,
        altura,
        peso,
        posicion,
        nombreEquipo);

    if (exito) {
      System.out.println("Jugador fichado correctamente.");
    } else {
      System.out.println("Error: Puede que el código esté repetido o el equipo no exista.");
    }
  }

  /**
   * Muestra los jugadores de un equipo específico seleccionado por el usuario.
   */
  private static void listarJugadores() {
    System.out.println("--- Lista de Jugadores ---");
    gestion.mostrarNombresEquipos();
    System.out.println("De que equipo quieres ver los jugadores ?");
    String nombre = sc.nextLine().trim();
    gestion.mostrarNombresJugadores(nombre);
  }

  /**
   * Solicita el nombre de un equipo para darlo de baja.
   * Muestra solo los equipos vacíos disponibles.
   */
  private static void bajaEquipo() {
    System.out.println("\n--- BAJA DE EQUIPO ---");

    if (!gestion.mostrarEquiposVacios()) {
      return;
    }

    System.out.print("Nombre del equipo a eliminar: ");
    String nombre = sc.nextLine().trim();

    boolean exito = gestion.bajaEquipo(nombre);

    if (exito) {
      System.out.println("Equipo eliminado correctamente.");
    } else {
      System.out.println("Error: No se ha podido eliminar el equipo. Verifica que no tenga jugadores o que exista.");
    }
  }

  /**
   * Solicita el código de un jugador para darlo de baja.
   * Primero pide el equipo para mostrar los jugadores disponibles.
   */
  private static void bajaJugador() {
    System.out.println("\n--- BAJA DE JUGADOR ---");

    System.out.println("Selecciona el equipo del jugador: ");
    gestion.mostrarNombresEquipos();

    System.out.print("Nombre del equipo: ");
    String nombreEquipo = sc.nextLine().trim();

    gestion.mostrarNombresJugadores(nombreEquipo);

    System.out.print("Introduce el código del jugador a eliminar: ");
    int codigo = sc.nextInt();
    sc.nextLine(); // Consumir salto de línea

    boolean exito = gestion.bajaJugador(codigo);

    if (exito) {
      System.out.println("Jugador eliminado correctamente.");
    } else {
      System.out.println("Error: No se ha podido eliminar el jugador. Verifica el código.");
    }
  }
}
