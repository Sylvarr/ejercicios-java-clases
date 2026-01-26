package pruebas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import interfaces.IGestionRutas;
import modelos_dao.GestionRutas;
import modelos_javabean.Camion;
import modelos_javabean.Empleado;
import modelos_javabean.Furgoneta;
import modelos_javabean.Ruta;

/**
 * Clase de prueba para verificar el funcionamiento de la lógica de negocio y la
 * gestión de rutas.
 * Se prueban las operaciones CRUD y las consultas de la clase GestionRutas.
 */
public class TestGestionRutas {

  static IGestionRutas irutas;
  static Scanner leer;
  static Ruta ruta;

  /**
   * Método principal que ejecuta la batería de pruebas.
   * 
   * @param args Argumentos de la línea de comandos (no utilizados).
   */
  public static void main(String[] args) {

    irutas = new GestionRutas();
    cargarDatos();
    testRutasPorEmpleado();
    testRutasPorVehiculo();
    testRutasPorDestino();
    testRutasIntervaloFechas();
    testTotalKmPorVehiculo();
    testTotalKmPorTipoVehiculo();
    testEliminarRuta();
  }

  /**
   * Inicializa los datos de prueba creando empleados, vehículos y rutas,
   * y añadiéndolos al sistema de gestión.
   */
  private static void cargarDatos() {

    Empleado emp1 = new Empleado("11111111A", "Juan", "Gomez", "juan@empresa.com", "H");
    Empleado emp2 = new Empleado("22222222B", "Ana", "Lopez", "ana@empresa.com", "M");
    Empleado emp3 = new Empleado("33333333C", "Carlos", "Ruiz", "carlos@empresa.com", "H");
    Empleado emp4 = new Empleado("44444444D", "Elena", "Diaz", "elena@empresa.com", "M");

    Camion camion1 = new Camion("1234-AA", "Renault", "Traveller", 50000, 25.0, 10000, 0, 3);
    Camion camion2 = new Camion("5678-CC", "Volvo", "FH16", 120000, 30.5, 24000, 0, 4);

    Furgoneta furgoneta1 = new Furgoneta("4567-AB", "Ford", "Transporter", 30000, 8.5, 10.0, 0);
    Furgoneta furgoneta2 = new Furgoneta("9012-DD", "Mercedes", "Vito", 45000, 9.2, 12.5, 0);

    Ruta ruta1 = new Ruta(1, LocalDate.of(2025, 10, 1), "Madrid", "Barcelona", camion1, emp1, 600.0, 5000);

    Ruta ruta2 = new Ruta(2, LocalDate.of(2025, 10, 5), "Sevilla", "Malaga", furgoneta1, emp2, 200.0, 450);

    Ruta ruta3 = new Ruta(3, LocalDate.of(2025, 10, 10), "Valencia", "Bilbao", camion2, emp3, 750.0, 12000);

    Ruta ruta4 = new Ruta(4, LocalDate.of(2025, 10, 15), "Barcelona", "Zaragoza", camion1, emp1, 300.0, 2000);

    Ruta ruta5 = new Ruta(5, LocalDate.of(2025, 10, 20), "Gijon", "Oviedo", furgoneta2, emp4, 50.0, 100);

    irutas.addRuta(ruta1);
    irutas.addRuta(ruta2);
    irutas.addRuta(ruta3);
    irutas.addRuta(ruta4);
    irutas.addRuta(ruta5);

    ruta = ruta4;
  }

  /**
   * Prueba la búsqueda de rutas por DNI de empleado.
   */
  private static void testRutasPorEmpleado() {
    System.out.println("------ RUTAS POR EMPLEADO -----");
    List<Ruta> resultados = irutas.rutasPorEmpleado("11111111A");
    for (Ruta ruta : resultados) {
      System.out.println(ruta);
    }
  }

  /**
   * Prueba la búsqueda de rutas por matrícula de vehículo.
   */
  private static void testRutasPorVehiculo() {
    System.out.println("------ RUTAS POR VEHICULO -----");
    List<Ruta> resultados = irutas.rutasPorVehiculo("5678-CC");
    for (Ruta ruta : resultados) {
      System.out.println(ruta);
    }
  }

  /**
   * Prueba la búsqueda de rutas por destino.
   */
  private static void testRutasPorDestino() {
    System.out.println("------ RUTAS POR DESTINO -----");
    List<Ruta> resultados = irutas.rutasPorDestino("Bilbao");
    for (Ruta ruta : resultados) {
      System.out.println(ruta);
    }
  }

  /**
   * Prueba la búsqueda de rutas dentro de un intervalo de fechas.
   */
  private static void testRutasIntervaloFechas() {
    System.out.println("------ RUTAS POR FECHA -----");
    List<Ruta> resultados = irutas.rutasIntervaloFechas(LocalDate.of(2025, 9, 30), LocalDate.of(2025, 10, 31));
    for (Ruta ruta : resultados) {
      System.out.println(ruta);
    }
  }

  /**
   * Prueba el cálculo del total de kilómetros por vehículo.
   */
  private static void testTotalKmPorVehiculo() {
    System.out.println("------ TOTAL KM POR VEHICULO -----");
    Map<String, Long> mapa = irutas.totalKmPorVehiculo();
    for (String matricula : mapa.keySet()) {
      long kilometros = mapa.get(matricula);

      System.out.println("El vehículo " + matricula + " ha recorrido: " + kilometros + " km.");
    }
  }

  /**
   * Prueba el cálculo del total de kilómetros por tipo de vehículo
   * (Camión/Furgoneta).
   */
  private static void testTotalKmPorTipoVehiculo() {
    System.out.println("------ TOTAL KM POR TIPO DE VEHICULO -----");
    Map<String, Long> mapa = irutas.totalKmPorTipoVehiculo();
    for (String matricula : mapa.keySet()) {
      long kilometros = mapa.get(matricula);

      System.out.println("El vehículo " + matricula + " ha recorrido: " + kilometros + " km.");
    }
  }

  /**
   * Prueba la eliminación de una ruta y verifica que ya no aparezca en las
   * búsquedas.
   */
  private static void testEliminarRuta() {
    System.out.println("------ TEST DE ELIMINAR RUTA POR OBJETO -----");
    System.out.println(ruta);
    irutas.eliminarRuta(ruta);

    System.out.println("Listando rutas de Juan tras borrar: ");
    List<Ruta> rutasDeJuan = irutas.rutasPorEmpleado("11111111A");

    for (Ruta ruta : rutasDeJuan) {
      System.out.println(ruta);
    }
  }
}
