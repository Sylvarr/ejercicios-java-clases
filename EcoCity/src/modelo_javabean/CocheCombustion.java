package modelo_javabean;

/**
 * Representa un coche de combustión interna.
 * Extiende {@link Vehiculo} añadiendo la cilindrada del motor
 * y un impuesto de circulación fijo de 200 €.
 *
 * @author pencho
 * @see Vehiculo
 */
public class CocheCombustion extends Vehiculo {

  /** Cilindrada del motor en centímetros cúbicos (cc). */
  private int cilindrada;

  /**
   * Crea un nuevo coche de combustión con los datos indicados.
   *
   * @param matricula  matrícula identificativa del vehículo
   * @param marca      marca del fabricante
   * @param modelo     modelo del vehículo
   * @param cilindrada cilindrada del motor en cc
   */
  public CocheCombustion(String matricula, String marca, String modelo, int cilindrada) {
    super(matricula, marca, modelo);
    this.cilindrada = cilindrada;
  }

  /**
   * Calcula el impuesto de circulación para un coche de combustión.
   *
   * @return impuesto fijo de 200.0 €
   */
  @Override
  public double calcularImpuesto() {
    return 200.0;
  }

  /**
   * Simula el repostaje de gasolina del vehículo.
   * Este método es {@code final} y no puede ser sobrescrito por subclases.
   */
  public final void repostarGasolina() {
    System.out.println("Llenando el depósito ...");
  }

  /**
   * Obtiene la cilindrada del motor.
   *
   * @return cilindrada en centímetros cúbicos
   */
  public int getCilindrada() {
    return cilindrada;
  }

  /**
   * Establece la cilindrada del motor.
   *
   * @param cilindrada nueva cilindrada en centímetros cúbicos
   */
  public void setCilindrada(int cilindrada) {
    this.cilindrada = cilindrada;
  }

  /**
   * Devuelve una representación en texto del coche de combustión,
   * incluyendo los datos del vehículo base y la cilindrada.
   *
   * @return cadena descriptiva del coche de combustión
   */
  @Override
  public String toString() {
    return super.toString() + " -> CocheCombustion [cilindrada=" + cilindrada + "]";
  }

}
