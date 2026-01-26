package pruebas;

import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

import modelos_javabean.Camion;
import modelos_javabean.Furgoneta;
import modelos_javabean.Vehiculo;

/**
 * Clase de prueba para verificar el comportamiento de la herencia y el
 * polimorfismo.
 * Comprueba que se pueden tratar diferentes tipos de vehículos (Camión,
 * Furgoneta)
 * de forma uniforme y acceder a sus propiedades específicas cuando es
 * necesario.
 */
public class TestHerencia {

  private static List<Vehiculo> vehiculos;
  // private static Scanner leer;

  /**
   * Método principal de la prueba.
   * 
   * @param args Argumentos de la línea de comandos.
   */
  public static void main(String[] args) {

    cargarDatos();
    listarVehiculos();

  }

  /**
   * Crea una lista de vehículos mixta (camiones y furgonetas) para probar el
   * polimorfismo.
   */
  private static void cargarDatos() {
    try {
      vehiculos = new ArrayList<>();
      Camion camion1 = new Camion("1234-AA", "Renault", "Traveller", 50000, 9, 10000, 0, 3);
      vehiculos.add(camion1);
      Camion camion2 = new Camion("8899-CC", "Volvo", "FH16", 120500, 28.5, 24000, 5000, 4);
      vehiculos.add(camion2);
      Furgoneta furgoneta1 = new Furgoneta("4567-AB", "Ford", "Transporter", 30000, 7, 10, 0);
      vehiculos.add(furgoneta1);
      Furgoneta furgoneta2 = new Furgoneta("1122-DD", "Mercedes", "Vito", 4500, 8.2, 12, 0);
      vehiculos.add(furgoneta2);
    } catch (IllegalArgumentException e) {
      System.out.println("Error creando vehículos: " + e.getMessage());
    }
  }

  /**
   * Recorre la lista de vehículos y muestra sus datos.
   * Utiliza 'instanceof' para mostrar información específica de cada tipo.
   */
  private static void listarVehiculos() {
    System.out.println("-------- DATOS DE LOS VEHICULOS --------");
    for (Vehiculo vehiculo : vehiculos) {
      System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + ", Matricula: " + vehiculo.getMatricula());
      if (vehiculo instanceof Camion) {
        System.out.println("Capacidad de carga del camión: " + ((Camion) vehiculo).getCapacidadCargaKg() + " kg.");
        System.out.println("Carga disponible: " + vehiculo.cargaDisponible() + " kg.");
      } else {
        System.out
            .println("Capacidad de carga de la furgoneta: " + ((Furgoneta) vehiculo).getVolumenCargaM3() + " m³.");
        System.out.println("Carga disponible: " + vehiculo.cargaDisponible() + " m³.");
      }
      System.out.println("-----------------------------------------");
    }
  }

}
