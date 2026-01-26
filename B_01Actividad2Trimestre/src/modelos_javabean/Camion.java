package modelos_javabean;

/**
 * Representa un camión, que es un tipo específico de vehículo.
 * Añade propiedades relacionadas con la carga en kilogramos y número de ejes.
 */
public class Camion extends Vehiculo {

  private double capacidadCargaKg;
  private double cargaOcupadaKg;
  private int numeroEjes;

  /**
   * Constructor completo para crear un Camión.
   * 
   * @param matricula          La matrícula.
   * @param marca              La marca.
   * @param modelo             El modelo.
   * @param kilometrosTotales  Los kilómetros totales.
   * @param consumoLitros100km El consumo.
   * @param capacidadCargaKg   La capacidad total de carga en Kg.
   * @param cargaOcupadaKg     La carga actualmente ocupada en Kg.
   * @param numeroEjes         El número de ejes del camión.
   */
  public Camion(String matricula,
      String marca,
      String modelo, double kilometrosTotales, double consumoLitros100km,
      double capacidadCargaKg, double cargaOcupadaKg, int numeroEjes) {
    super(matricula, marca, modelo, kilometrosTotales, consumoLitros100km);
    setCapacidadCargaKg(capacidadCargaKg);
    setCargaOcupadaKg(cargaOcupadaKg);
    setNumeroEjes(numeroEjes);
  }

  /**
   * Constructor vacío.
   */
  public Camion() {
    super();
  }

  /**
   * Calcula la carga disponible en el camión.
   * 
   * @return La cantidad de carga que aún se puede añadir en Kg.
   */
  @Override
  public double cargaDisponible() {
    return capacidadCargaKg - cargaOcupadaKg;
  }

  /**
   * Calcula el porcentaje de carga ocupada en el camión.
   * 
   * @return El porcentaje de carga ocupada.
   */
  @Override
  public double getPorcentajeCarga() {

    return (cargaOcupadaKg / capacidadCargaKg) * 100;
  }

  /**
   * Comprueba si el camión está lleno (su carga ocupada es igual a su capacidad).
   * 
   * @return true si el camión está lleno, false en caso contrario.
   */
  @Override
  public boolean isLleno() {
    if (capacidadCargaKg == cargaOcupadaKg) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Obtiene la capacidad máxima de carga del camión en kilogramos.
   * 
   * @return La capacidad de carga en Kg.
   */
  public double getCapacidadCargaKg() {
    return capacidadCargaKg;
  }

  /**
   * Establece la capacidad de carga del camión.
   * 
   * @param capacidadCargaKg La capacidad a establecer (3500 - 40000 Kg).
   * @throws IllegalArgumentException Si el valor está fuera de rango.
   */
  public void setCapacidadCargaKg(double capacidadCargaKg) {

    if (capacidadCargaKg >= 3500 && capacidadCargaKg <= 40000) {
      this.capacidadCargaKg = capacidadCargaKg;
    } else {
      throw new IllegalArgumentException("La capacidad de carga tiene que estar entre 3500 y 40000kg.");
    }
  }

  /**
   * Obtiene la carga actualmente ocupada en el camión en kilogramos.
   * 
   * @return La carga ocupada en Kg.
   */
  public double getCargaOcupadaKg() {
    return cargaOcupadaKg;
  }

  /**
   * Establece la carga ocupada, asegurando que no exceda la capacidad.
   * 
   * @param cargaOcupadaKg La carga ocupada.
   * @throws IllegalArgumentException Si la carga ocupada es negativa o excede la
   *                                  capacidad.
   */
  public void setCargaOcupadaKg(double cargaOcupadaKg) {

    if (cargaOcupadaKg >= 0 && cargaOcupadaKg <= capacidadCargaKg) {
      this.cargaOcupadaKg = cargaOcupadaKg;
    } else {
      throw new IllegalArgumentException("La carga ocupada tiene que estar entre 0 y " + capacidadCargaKg + " kg.");
    }
  }

  /**
   * Obtiene el número de ejes del camión.
   * 
   * @return El número de ejes.
   */
  public int getNumeroEjes() {
    return numeroEjes;
  }

  /**
   * Establece el número de ejes del camión.
   * 
   * @param numeroEjes El número de ejes (2 - 8).
   * @throws IllegalArgumentException Si el valor está fuera de rango.
   */
  public void setNumeroEjes(int numeroEjes) {

    if (numeroEjes >= 2 && numeroEjes <= 8) {
      this.numeroEjes = numeroEjes;
    } else {
      throw new IllegalArgumentException("El número de ejes puede ser entre 2 y 8");
    }

  }

  @Override
  public String toString() {
    return "Camion [capacidadCargaKg=" + capacidadCargaKg + ", cargaOcupadaKg=" + cargaOcupadaKg + ", numeroEjes="
        + numeroEjes + "]" + super.toString();
  }

}
