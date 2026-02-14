package modelo_javabean;

/**
 * Clase abstracta que representa un vehículo genérico en el sistema EcoCity.
 * Sirve como clase base para los distintos tipos de vehículos (eléctricos, combustión, etc.).
 * Lleva un contador estático del total de vehículos creados.
 *
 * @author pencho
 */
public abstract class Vehiculo {

  /** Matrícula del vehículo. Es inmutable una vez asignada. */
  protected final String matricula;

  /** Contador estático que registra el número total de vehículos instanciados. */
  private static int contadorVehiculos = 0;

  /** Marca del vehículo. */
  protected String marca;

  /** Modelo del vehículo. */
  protected String modelo;

  /**
   * Crea un nuevo vehículo con los datos indicados e incrementa el contador global.
   *
   * @param matricula matrícula identificativa del vehículo
   * @param marca     marca del fabricante
   * @param modelo    modelo del vehículo
   */
  public Vehiculo(String matricula, String marca, String modelo) {
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
    contadorVehiculos++;
  }

  /**
   * Calcula el impuesto de circulación asociado al vehículo.
   * Cada subclase debe proporcionar su propia implementación.
   *
   * @return importe del impuesto en euros
   */
  public abstract double calcularImpuesto();

  /**
   * Simula el arranque del vehículo mostrando un mensaje por consola.
   */
  public void arrancar() {
    System.out.println("El vehículo ha arrancado.");
  }

  /**
   * Devuelve el número total de vehículos creados hasta el momento.
   *
   * @return total de vehículos instanciados
   */
  public int totalVehiculos() {
    return contadorVehiculos;
  }

  /**
   * Obtiene la matrícula del vehículo.
   *
   * @return matrícula del vehículo
   */
  public String getMatricula() {
    return matricula;
  }

  /**
   * Obtiene el número total de vehículos creados (método estático).
   *
   * @return total de vehículos instanciados
   */
  public static int getContadorVehiculos() {
    return contadorVehiculos;
  }

  /**
   * Establece el valor del contador de vehículos.
   *
   * @param contadorVehiculos nuevo valor del contador
   */
  public static void setContadorVehiculos(int contadorVehiculos) {
    Vehiculo.contadorVehiculos = contadorVehiculos;
  }

  /**
   * Obtiene la marca del vehículo.
   *
   * @return marca del fabricante
   */
  public String getMarca() {
    return marca;
  }

  /**
   * Establece la marca del vehículo.
   *
   * @param marca nueva marca del fabricante
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * Obtiene el modelo del vehículo.
   *
   * @return modelo del vehículo
   */
  public String getModelo() {
    return modelo;
  }

  /**
   * Establece el modelo del vehículo.
   *
   * @param modelo nuevo modelo del vehículo
   */
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  /**
   * Devuelve una representación en texto del vehículo con su matrícula, marca y modelo.
   *
   * @return cadena descriptiva del vehículo
   */
  @Override
  public String toString() {
    return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + "]";
  }

}
