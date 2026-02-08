package interfaces;

/**
 * Interfaz que define la capacidad de un dispositivo para conectarse a una red WiFi.
 * Debe ser implementada por cualquier dispositivo domótico que disponga de chip WiFi.
 *
 * @author pencho
 */
public interface Conectable {

  /**
   * Conecta el dispositivo a la red WiFi indicada.
   *
   * @param nombreRed nombre de la red WiFi a la que se desea conectar
   */
  public abstract void conectarWifi(String nombreRed);

}
