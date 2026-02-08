package modelo_javabean;

/**
 * Clase abstracta que representa un dispositivo genérico en una casa domótica.
 * Lleva un contador estático del total de dispositivos creados.
 *
 * @author pencho
 */
public abstract class Dispositivo {

  /** Nombre identificativo del dispositivo. */
  protected String nombre;

  /** Contador estático del número total de dispositivos instanciados. */
  private static int cantidadTotal = 0;

  /**
   * Crea un nuevo dispositivo con el nombre indicado e incrementa el contador total.
   *
   * @param nombre nombre identificativo del dispositivo
   */
  public Dispositivo(String nombre) {
    this.nombre = nombre;
    cantidadTotal++;
  }

  /**
   * Enciende el dispositivo. Cada subclase define su propio comportamiento de encendido.
   */
  public abstract void encender();

  /**
   * Devuelve el número total de dispositivos que se han creado.
   *
   * @return cantidad total de dispositivos instanciados
   */
  public static int getCantidadTotal() {
    return cantidadTotal;
  }

  /**
   * Devuelve el nombre del dispositivo.
   *
   * @return nombre del dispositivo
   */
  public String getNombre() {
    return nombre;
  }

}
