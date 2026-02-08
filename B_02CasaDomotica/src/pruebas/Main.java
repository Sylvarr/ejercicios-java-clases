package pruebas;

import java.util.ArrayList;
import modelo_javabean.*;
import interfaces.Conectable;

/**
 * Clase de pruebas que demuestra el funcionamiento del sistema de casa domótica.
 * Crea varios dispositivos, los enciende y prueba la conexión WiFi
 * en aquellos que implementan {@link Conectable}.
 *
 * @author pencho
 */
public class Main {

  /**
   * Punto de entrada de la aplicación.
   * Crea un televisor y una lámpara, los enciende y conecta al WiFi
   * los que sean compatibles.
   *
   * @param args argumentos de línea de comandos (no utilizados)
   */
  public static void main(String[] args) {

    ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();

    Televisor televisor = new Televisor("Samsung", 55);
    Lampara lampara = new Lampara("LG Light", "LED");

    listaDispositivos.add(televisor);
    listaDispositivos.add(lampara);

    System.out.println("--- INVENTARIO ---");

    System.out.println("Total dispositivos fabricados: " + Dispositivo.getCantidadTotal());

    System.out.println("\n--- ENCENDIENDO APARATOS ---");
    for (Dispositivo aparato : listaDispositivos) {
      aparato.encender();
    }

    System.out.println("\n--- CONECTANDO AL WIFI ---");
    for (Dispositivo aparato : listaDispositivos) {

      if (aparato instanceof Conectable) {
        ((Conectable) aparato).conectarWifi("Movistar_Fibra");
      } else {
        System.out.println(aparato.getNombre() + ": Error. Este dispositivo no tiene chip WiFi.");
      }
    }
  }
}
