package pruebas;

import modelo_dao.ClubDaoSet;
import modelo_javabean.Socio;

/**
 * Clase de pruebas para verificar el alta de socios en el club.
 * <p>
 * Crea un socio y lo intenta dar de alta dos veces para comprobar
 * que no se permiten duplicados.
 * </p>
 *
 * @author pencho
 */
public class TestClub {

  /**
   * Punto de entrada del programa de pruebas.
   *
   * @param args argumentos de la línea de comandos (no se utilizan)
   */
  public static void main(String[] args) {

    Socio pencho = new Socio("Pencho");
    ClubDaoSet dao = new ClubDaoSet();

    dao.altaSocio(pencho);
    dao.altaSocio(pencho);

  }
}
