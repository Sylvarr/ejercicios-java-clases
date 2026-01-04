package A_07Concesionario.modelos;

/**
 * Clase que representa una moto. Hereda de Vehiculo y añade el atributo
 * cilindrada.
 */
public class Moto extends Vehiculo {

  private int cilindrada;

  /**
   * Constructor de la moto que valida la cilindrada.
   * 
   * @param marca      Marca de la moto
   * @param modelo     Modelo de la moto
   * @param precio     Precio de la moto
   * @param cilindrada Cilindrada en cc (100-2500)
   * @throws IllegalArgumentException Si la cilindrada está fuera del rango
   *                                  permitido
   */
  public Moto(String marca, String modelo, double precio, int cilindrada) {

    super(marca, modelo, precio);
    setCilindrada(cilindrada);

  }

  /**
   * Asigna la cilindrada validando que esté entre 100 y 2500 cc.
   * 
   * @param cilindrada Cilindrada a asignar
   */
  public void setCilindrada(int cilindrada) {

    if (cilindrada >= 100 && cilindrada <= 2500) {
      this.cilindrada = cilindrada;
    } else {
      throw new IllegalArgumentException("Error fatal: La cilindrada debe ser entre 100cc y 2500cc");
    }

  }

  /**
   * Obtiene la cilindrada de la moto.
   * 
   * @return Cilindrada en cc
   */
  public int getCilindrada() {
    return cilindrada;
  }

  @Override
  public void mostrarDetalles() {
    super.mostrarDetalles();
    System.out.println("Cilindrada: " + cilindrada + "cc");
  }

  @Override
  public String toString() {
    return "Moto [cilindrada=" + cilindrada + "]";
  }

}
