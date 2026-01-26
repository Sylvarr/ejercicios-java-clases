package modelos_javabean;

/**
 * Representa una furgoneta, que es un tipo específico de vehículo.
 * Se caracteriza por su volumen de carga en metros cúbicos.
 */
public class Furgoneta extends Vehiculo {

  private double volumenCargaM3;
  private double volumenOcupadoM3;

  /**
   * Constructor completo para crear una Furgoneta.
   * 
   * @param matricula          La matrícula.
   * @param marca              La marca.
   * @param modelo             El modelo.
   * @param kilometrosTotales  Los kilómetros totales.
   * @param consumoLitros100km El consumo.
   * @param volumenCargaM3     El volumen total de carga en m3.
   * @param volumenOcupadoM3   El volumen actualmente ocupado en m3.
   */
  public Furgoneta(String matricula, String marca, String modelo, double kilometrosTotales, double consumoLitros100km,
      double volumenCargaM3, double volumenOcupadoM3) {
    super(matricula, marca, modelo, kilometrosTotales, consumoLitros100km);
    setVolumenCargaM3(volumenCargaM3);
    setVolumenOcupadoM3(volumenOcupadoM3);
  }

  /**
   * Calcula el volumen disponible en la furgoneta.
   * 
   * @return El volumen disponible en m3.
   */
  @Override
  public double cargaDisponible() {

    if (volumenOcupadoM3 == 0) {
      System.out.println("La furgoneta está vacia.");
    }
    return volumenCargaM3 - volumenOcupadoM3;

  }

  /**
   * Calcula el porcentaje de volumen ocupado.
   * 
   * @return El porcentaje de ocupación.
   */
  @Override
  public double getPorcentajeCarga() {
    return (volumenOcupadoM3 / volumenCargaM3) * 100;
  }

  /**
   * Verifica si la furgoneta está llena.
   * 
   * @return true si el volumen ocupado iguala al volumen de carga, false en caso
   *         contrario.
   */
  @Override
  public boolean isLleno() {

    if (volumenCargaM3 == volumenOcupadoM3) {
      return true;
    } else {
      return false;
    }

  }

  public double getVolumenCargaM3() {
    return volumenCargaM3;
  }

  /**
   * Establece el volumen de carga de la furgoneta.
   * 
   * @param volumenCargaM3 El volumen de carga (5 - 15 m3).
   * @throws IllegalArgumentException Si el valor está fuera de rango.
   */
  public void setVolumenCargaM3(double volumenCargaM3) {

    if (volumenCargaM3 >= 5 && volumenCargaM3 <= 15) {
      this.volumenCargaM3 = volumenCargaM3;
    } else {
      throw new IllegalArgumentException("Error en el valor de carga (5 - 15m³).");
    }

  }

  public double getVolumenOcupadoM3() {
    return volumenOcupadoM3;
  }

  /**
   * Establece el volumen ocupado, asegurando que no exceda la capacidad.
   * 
   * @param volumenOcupadoM3 El volumen ocupado.
   * @throws IllegalArgumentException Si el valor es negativo o excede la
   *                                  capacidad.
   */
  public void setVolumenOcupadoM3(double volumenOcupadoM3) {
    if (volumenOcupadoM3 >= 0 && volumenOcupadoM3 <= volumenCargaM3) {
      this.volumenOcupadoM3 = volumenOcupadoM3;
    } else {
      throw new IllegalArgumentException("Error en el volumen ocupado (0 - " + volumenCargaM3 + ").");
    }

  }

  @Override
  public String toString() {
    return "Furgoneta [volumenCargaM3=" + volumenCargaM3 + ", volumenOcupadoM3=" + volumenOcupadoM3 + "]"
        + super.toString();
  }

}
