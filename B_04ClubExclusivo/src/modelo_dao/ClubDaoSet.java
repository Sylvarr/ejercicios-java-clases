package modelo_dao;

import interfaces.ClubDAO;
import modelo_javabean.Socio;

import java.util.HashSet;

/**
 * Implementación de {@link ClubDAO} que almacena los socios
 * en un {@link HashSet}, impidiendo duplicados.
 *
 * @author pencho
 */
public class ClubDaoSet implements ClubDAO {

  /** Conjunto interno que almacena los socios del club. */
  HashSet<Socio> listaSocios = new HashSet<>();

  /**
   * Da de alta a un socio en el club.
   * <p>
   * Si el socio ya existe (según {@link Socio#equals(Object)}),
   * se muestra un mensaje de error por consola.
   * </p>
   *
   * @param s el socio que se desea registrar
   */
  @Override
  public void altaSocio(Socio s) {

    if (listaSocios.add(s)) {
      System.out.println("Socio añadido: " + s);
    } else {
      System.out.println("Error: El socio ya existe.");
    }

  }

}
