package interfaces;

/**
 * Interfaz que define el comportamiento de un vehículo electrificable.
 * Proporciona métodos para cargar la batería y revisar el sistema eléctrico.
 *
 * @author pencho
 */
public interface Electrificable {

  /** Voltaje máximo permitido en el sistema eléctrico (en voltios). */
  final int VOLTAJE_MAXIMO = 200;

  /**
   * Carga la batería del vehículo con la cantidad especificada.
   *
   * @param cantidad porcentaje de carga a añadir
   */
  void cargarBateria(int cantidad);

  /**
   * Realiza una revisión del sistema eléctrico del vehículo.
   * La implementación por defecto muestra un mensaje de verificación correcta.
   */
  default void revisarSistema() {
    System.out.println("Sistema electrico verificado: OK");
  }

}
