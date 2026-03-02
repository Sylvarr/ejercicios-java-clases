package interfaces;

import modelos.javabean.Envio;
import java.util.*;

/**
 * Interfaz que define las operaciones para la gestión de envíos.
 */
public interface IGestorEnvios {

  /**
   * Registra un nuevo envío en el sistema.
   *
   * @param e El envío a registrar.
   */
  void registrarEnvio(Envio e);

  /**
   * Cuenta el número de envíos agrupados por ciudad de destino.
   *
   * @return Un mapa donde la clave es la ciudad de destino y el valor es la
   *         cantidad de envíos a esa ciudad.
   */
  Map<String, Integer> contarEnviosPorCiudad();

  /**
   * Agrupa los envíos registrados por ciudad de destino.
   *
   * @return Un mapa donde la clave es la ciudad de destino y el valor es una
   *         lista de los envíos a esa ciudad.
   */
  Map<String, List<Envio>> agruparEnviosPorCiudad();

}
