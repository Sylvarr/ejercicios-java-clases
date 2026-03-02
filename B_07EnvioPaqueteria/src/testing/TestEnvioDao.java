package testing;

import modelos.dao.EnvioDAO;
import modelos.javabean.Envio;
import modelos.javabean.EnvioEstandar;
import modelos.javabean.EnvioExpress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la clase {@link EnvioDAO}.
 * Utiliza JUnit 5 para verificar el correcto funcionamiento de los métodos de
 * registro y consulta de envíos.
 */
public class TestEnvioDao {

  private EnvioDAO envioDAO;
  private EnvioEstandar envioEstandar;
  private EnvioExpress envioExpress;

  /**
   * Configuración inicial que se ejecuta antes de cada método de prueba.
   * Inicializa el DAO y registra algunos envíos de prueba.
   */
  @BeforeEach
  void setUp() {
    envioDAO = new EnvioDAO();
    envioEstandar = new EnvioEstandar("01", "Madrid", 1100, 2);
    envioExpress = new EnvioExpress("02", "Barcelona", 1300, true);
    envioDAO.registrarEnvio(envioEstandar);
    envioDAO.registrarEnvio(envioExpress);
  }

  /**
   * Prueba que se lance una excepción {@link IllegalArgumentException} al
   * intentar registrar un envío nulo.
   */
  @Test
  void testRegistrarEnvioNulo() {
    assertThrows(IllegalArgumentException.class, () -> {
      envioDAO.registrarEnvio(null);
    });
  }

  /**
   * Prueba el correcto registro de un nuevo envío verificando que el tamaño de la
   * lista aumenta en uno.
   */
  @Test
  void testRegistrarEnvio() {
    EnvioEstandar nuevoEnvio = new EnvioEstandar("05", "Valencia", 500, 1);
    envioDAO.registrarEnvio(nuevoEnvio);
    assertEquals(3, envioDAO.getListaEnvios().size());
  }

  /**
   * Prueba el método {@link EnvioDAO#contarEnviosPorCiudad()} verificando que el
   * mapa devuelto contiene la ciudad "Madrid".
   */
  @Test
  void testContarEnviosPorCiudad() {
    assertTrue(envioDAO.contarEnviosPorCiudad().containsKey("Madrid"));
  }

  /**
   * Prueba el método {@link EnvioDAO#agruparEnviosPorCiudad()} verificando que la
   * agrupación se realiza correctamente,
   * comprobando las claves, el tamaño de las listas y la referencia al objeto
   * esperado.
   */
  @Test
  void testAgruparEnviosPorCiudad() {
    Map<String, List<Envio>> mapaCiudaddes = envioDAO.agruparEnviosPorCiudad();

    assertTrue(mapaCiudaddes.containsKey("Madrid"));

    assertEquals(1, mapaCiudaddes.get("Madrid").size());

    assertEquals(envioEstandar, mapaCiudaddes.get("Madrid").get(0));
  }
}
