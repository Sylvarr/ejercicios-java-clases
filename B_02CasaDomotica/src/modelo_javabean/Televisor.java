package modelo_javabean;

import interfaces.Conectable;

/**
 * Representa un televisor dentro de la casa domótica.
 * Extiende {@link Dispositivo} e implementa {@link Conectable} para poder conectarse a WiFi.
 *
 * @author pencho
 */
public class Televisor extends Dispositivo
    implements Conectable {

  /** Tamaño de la pantalla en pulgadas (mínimo 10). */
  private int pulgadas;

  /**
   * Crea un nuevo televisor con el nombre y las pulgadas indicadas.
   *
   * @param nombre   nombre identificativo del televisor
   * @param pulgadas tamaño de la pantalla en pulgadas
   */
  public Televisor(String nombre, int pulgadas) {

    super(nombre);
    this.pulgadas = pulgadas;

  }

  /**
   * Establece el tamaño de la pantalla en pulgadas.
   * Si el valor proporcionado es menor o igual a 10, se asigna 10 como mínimo.
   *
   * @param pulgadas nuevo tamaño de pantalla en pulgadas
   */
  public void setPulgadas(int pulgadas) {

    if (pulgadas > 10) {
      this.pulgadas = pulgadas;
    } else {
      this.pulgadas = 10;
    }

  }

  /**
   * Enciende el televisor mostrando por consola su nombre y tamaño de pantalla.
   */
  @Override
  public void encender() {
    System.out.println("Encendiendo " + nombre + " TV de " + pulgadas + " pulgadas.");
  }

  /**
   * {@inheritDoc}
   * Conecta el televisor a la red WiFi indicada mostrando un mensaje por consola.
   */
  @Override
  public void conectarWifi(String nombreRed) {
    System.out.println("Conectando TV " + nombre + " a la red " + nombreRed + ".");
  }

}
