package interfaces;

import modelo_javabean.Socio;

/**
 * Interfaz DAO que define las operaciones de gestión de socios del club.
 *
 * @author pencho
 */
public interface ClubDAO {

  /** Número máximo de socios permitidos en el club. */
  int MAX_SOCIOS = 100;

  /**
   * Da de alta a un socio en el club.
   *
   * @param s el socio que se desea registrar
   */
  void altaSocio(Socio s);

}
