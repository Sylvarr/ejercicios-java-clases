package modelo_javabean;

import interfaces.Electrificable;

/**
 * Representa un coche eléctrico en el sistema EcoCity.
 * Extiende {@link Vehiculo} e implementa {@link Electrificable},
 * proporcionando funcionalidad de carga de batería y revisión del sistema eléctrico.
 * Los coches eléctricos están exentos del impuesto de circulación.
 *
 * @author pencho
 * @see Vehiculo
 * @see Electrificable
 */
public class CocheElectrico extends Vehiculo implements Electrificable {

  /** Porcentaje actual de carga de la batería (0-100). */
  private int porcentajeBateria;

  /**
   * Crea un nuevo coche eléctrico con los datos indicados.
   *
   * @param matricula        matrícula identificativa del vehículo
   * @param marca            marca del fabricante
   * @param modelo           modelo del vehículo
   * @param porcentajeBateria porcentaje inicial de carga de la batería (0-100)
   */
  public CocheElectrico(String matricula, String marca, String modelo, int porcentajeBateria) {
    super(matricula, marca, modelo);
    this.porcentajeBateria = porcentajeBateria;
  }

  /**
   * Calcula el impuesto de circulación para un coche eléctrico.
   * Los coches eléctricos están exentos, por lo que devuelve 0.
   *
   * @return 0.0 (exento de impuesto)
   */
  @Override
  public double calcularImpuesto() {
    return 0;
  }

  /**
   * Carga la batería del coche eléctrico con la cantidad indicada.
   * Si la carga resultante supera el 100%, no se realiza la carga
   * y se muestra un mensaje de capacidad insuficiente.
   *
   * @param carga porcentaje de carga a añadir
   */
  public void cargarBateria(int carga) {
    if ((carga + porcentajeBateria) <= 100) {
      porcentajeBateria += carga;
    } else {
      System.out.println("Capacidad insuficiente.");
    }
  }

  /**
   * Realiza una revisión del sistema eléctrico del coche,
   * comprobando las celdas de iones de litio.
   */
  @Override
  public void revisarSistema() {
    System.out.println("Comprobando celdas de iones de litio ...");
  }

}
