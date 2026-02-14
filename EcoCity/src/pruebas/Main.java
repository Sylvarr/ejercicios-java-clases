package pruebas;

import interfaces.Electrificable;
import modelo_javabean.CocheCombustion;
import modelo_javabean.CocheElectrico;
import modelo_javabean.Vehiculo;
import java.util.ArrayList;

/**
 * Clase de pruebas que demuestra el funcionamiento del sistema EcoCity.
 * Crea instancias de distintos tipos de vehículos y prueba herencia,
 * polimorfismo e implementación de interfaces.
 *
 * @author pencho
 */
public class Main {

  /**
   * Punto de entrada de la aplicación.
   * Crea vehículos de combustión y eléctricos, demuestra la asignación
   * por referencia, el uso de constantes de interfaz, el contador estático
   * de vehículos y el polimorfismo con {@code instanceof}.
   *
   * @param args argumentos de línea de comandos (no utilizados)
   */
  public static void main(String[] args) {

    CocheCombustion c1 = new CocheCombustion("000", "Peugeot", "4007", 1800);

    CocheElectrico c3 = new CocheElectrico("0000", "Tesla", "Model Y    ", 100);

    CocheCombustion c2 = c1;

    c2.setMarca("Mercedes");

    System.out.println(c1.getMarca());

    System.out.println(Electrificable.VOLTAJE_MAXIMO);

    System.out.println(Vehiculo.getContadorVehiculos());

    ArrayList<Vehiculo> listaCoches = new ArrayList<>();
    listaCoches.add(c1);
    listaCoches.add(c3);

    for (Vehiculo coche : listaCoches) {

      System.out.println(coche.calcularImpuesto());

      if (coche instanceof Electrificable) {
        Electrificable e = (Electrificable) coche;
        e.revisarSistema();
        e.cargarBateria(50);
      }

    }

  }
}
