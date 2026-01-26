package modelos_javabean;

/**
 * Representa un vehículo genérico en la flota de transporte.
 * Esta clase es abstracta y sirve como base para tipos específicos de vehículos.
 */
public abstract class Vehiculo {

  protected String matricula;
  protected String marca;
  protected String modelo;
  protected double kilometrosTotales;
  protected double consumoLitros100km;

  /**
   * Calcula la carga disponible que puede transportar el vehículo.
   * @return La carga disponible.
   */
  public abstract double cargaDisponible();

  /**
   * Calcula el porcentaje de carga actual del vehículo.
   * @return El porcentaje de carga.
   */
  public abstract double getPorcentajeCarga();

  /**
   * Verifica si el vehículo está lleno.
   * @return true si está lleno, false en caso contrario.
   */
  public abstract boolean isLleno();

  /**
   * Aumenta el kilometraje total del vehículo.
   * @param kilometros La cantidad de kilómetros a añadir (debe ser positiva).
   * @throws IllegalArgumentException Si los kilómetros son negativos o cero.
   */
  public void aumentarKilometraje(double kilometros) {

    if (kilometros > 0) {
      kilometrosTotales += kilometros;
    } else {
      throw new IllegalArgumentException("Por favor introduce un número positivo.");
    }

  };

  /**
   * Modifica el consumo de combustible del vehículo.
   * @param nuevoConsumo El nuevo consumo en litros a los 100km.
   */
  public void modificarConsumoLitros100km(double nuevoConsumo) {
    setConsumoLitros100km(nuevoConsumo);
  }

  /**
   * Constructor completo para crear un Vehículo.
   * @param matricula La matrícula del vehículo.
   * @param marca La marca del vehículo.
   * @param modelo El modelo del vehículo.
   * @param kilometrosTotales Los kilómetros totales recorridos.
   * @param consumoLitros100km El consumo medio en l/100km.
   */
  public Vehiculo(String matricula, String marca, String modelo, double kilometrosTotales, double consumoLitros100km) {
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
    setKilometrosTotales(kilometrosTotales);
    setConsumoLitros100km(consumoLitros100km);
  }

  /**
   * Constructor vacío.
   */
  public Vehiculo() {

  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public double getKilometrosTotales() {
    return kilometrosTotales;
  }

  /**
   * Establece el kilometraje total, validando que esté en un rango lógico.
   * @param kilometrosTotales Los kilómetros a establecer (0 - 3,000,000).
   * @throws IllegalArgumentException Si el valor está fuera de rango.
   */
  public void setKilometrosTotales(double kilometrosTotales) {

    if (kilometrosTotales >= 0 && kilometrosTotales <= 3000000) {
      this.kilometrosTotales = kilometrosTotales;
    } else {
      throw new IllegalArgumentException("Kilometraje no válido. Debe estar entre 0 y 3,000,000 km.");
    }

  }

  public double getConsumoLitros100km() {
    return consumoLitros100km;
  }

  /**
   * Establece el consumo de combustible, validando un rango lógico.
   * @param consumoLitros100km El consumo a establecer (3 - 100 l/100km).
   * @throws IllegalArgumentException Si el valor está fuera de rango.
   */
  public void setConsumoLitros100km(double consumoLitros100km) {
    if (consumoLitros100km >= 3 && consumoLitros100km <= 100) {
      this.consumoLitros100km = consumoLitros100km;
    } else {
      throw new IllegalArgumentException(
          "Error: Consumo fuera de rango (3-100 litros/100km).");
    }

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vehiculo other = (Vehiculo) obj;
    if (matricula == null) {
      if (other.matricula != null)
        return false;
    } else if (!matricula.equals(other.matricula))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometrosTotales="
        + kilometrosTotales + ", consumoLitros100km=" + consumoLitros100km + "]";
  }

}
