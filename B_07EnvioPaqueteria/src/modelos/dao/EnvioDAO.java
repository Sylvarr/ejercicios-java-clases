package modelos.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IGestorEnvios;
import modelos.javabean.Envio;

/**
 * Implementación de la interfaz {@link IGestorEnvios} que gestiona una
 * colección de envíos en memoria.
 */
public class EnvioDAO implements IGestorEnvios {

  /**
   * Lista interna que almacena los envíos registrados.
   */
  List<Envio> listaEnvios = new ArrayList<>();

  /**
   * Obtiene la lista de todos los envíos registrados.
   *
   * @return La lista de envíos.
   */
  public List<Envio> getListaEnvios() {
    return listaEnvios;
  }

  /**
   * Registra un nuevo envío añadiéndolo a la lista interna.
   *
   * @param e El envío a registrar.
   * @throws IllegalArgumentException si el envío proporcionado es nulo.
   */
  public void registrarEnvio(Envio e) {

    if (e == null) {
      throw new IllegalArgumentException("Error: Este envío no existe.");
    }

    listaEnvios.add(e);

  }

  /**
   * Cuenta el número de envíos agrupados por ciudad de destino.
   *
   * @return Un mapa donde la clave es la ciudad de destino y el valor es la
   *         cantidad de envíos a esa ciudad.
   */
  @Override
  public Map<String, Integer> contarEnviosPorCiudad() {
    Map<String, Integer> mapaEnvios = new HashMap<>();
    for (Envio envio : listaEnvios) {
      mapaEnvios.put(envio.getCiudadDestino(), mapaEnvios.getOrDefault(envio.getCiudadDestino(), 0) + 1);
    }

    return mapaEnvios;
  }

  /**
   * Agrupa los envíos registrados por ciudad de destino.
   *
   * @return Un mapa donde la clave es la ciudad de destino y el valor es una
   *         lista de los envíos a esa ciudad.
   */
  @Override
  public Map<String, List<Envio>> agruparEnviosPorCiudad() {
    Map<String, List<Envio>> mapaEnviosPorCiudad = new HashMap<>();

    for (Envio envio : listaEnvios) {
      mapaEnviosPorCiudad.putIfAbsent(envio.getCiudadDestino(), new ArrayList<>());

      mapaEnviosPorCiudad.get(envio.getCiudadDestino()).add(envio);

    }

    return mapaEnviosPorCiudad;

  }

}
