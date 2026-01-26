package modelos_javabean;

import java.time.LocalDate;

/**
 * Representa una ruta realizada por un empleado con un vehículo.
 * Contiene información sobre el trayecto, la carga y los recursos utilizados.
 */
public class Ruta {

  private int idRuta;
  private LocalDate fecha;
  private String origen;
  private String destino;
  private Vehiculo vehiculoUsado;
  private Empleado empleado;
  private double kmRecorridos;
  private double cargaTransportadaKg;

  /**
   * Constructor completo para crear una Ruta.
   * 
   * @param idRuta              El identificador único de la ruta.
   * @param fecha               La fecha de la ruta.
   * @param origen              El lugar de origen.
   * @param destino             El lugar de destino.
   * @param vehiculoUsado       El vehículo utilizado.
   * @param empleado            El empleado que realiza la ruta.
   * @param kmRecorridos        Los kilómetros recorridos en la ruta.
   * @param cargaTransportadaKg La carga transportada en Kg.
   */
  public Ruta(int idRuta, LocalDate fecha, String origen, String destino, Vehiculo vehiculoUsado, Empleado empleado,
      double kmRecorridos, double cargaTransportadaKg) {
    this.idRuta = idRuta;
    this.fecha = fecha;
    this.origen = origen;
    this.destino = destino;
    this.vehiculoUsado = vehiculoUsado;
    this.empleado = empleado;
    this.kmRecorridos = kmRecorridos;
    this.cargaTransportadaKg = cargaTransportadaKg;
  }

  /**
   * Constructor vacío.
   */
  public Ruta() {

  }

  /**
   * Verifica si la carga transportada es adecuada para el vehículo.
   * 
   * @return true si el vehículo soporta la carga, false si la sobrepasa o si no
   *         se puede determinar.
   */
  public boolean isCargaCorrecta() {
    if (vehiculoUsado instanceof Camion) {
      Camion camion = (Camion) vehiculoUsado;
      return camion.getCapacidadCargaKg() >= cargaTransportadaKg;
    }

    // Si el Vehiculo no es un Camion, no es posible averiguar
    // La carga debido a que no es en metros cúbicos
    System.out.println("No es posible saber si la carga es correcta debido a que el vehiculo es una furgoneta. ");
    return false;

  }

  /**
   * Actualiza los kilómetros totales del vehículo usado basándose en esta ruta.
   */
  public void modificarKilometrosYConsumoVehiculo() {
    // Solo disponemos de datos sobre los km recorridos. No hay datos de cambio
    // en el consumo. El metodo modificarConsumoLitros100km de Vehiculo se queda
    // sin utilizar
    vehiculoUsado.aumentarKilometraje(kmRecorridos);

  }

  /**
   * Obtiene una cadena resumen de la ruta.
   * 
   * @return Cadena con origen, destino y kilómetros.
   */
  public String getOrigenDestino() {
    return origen + "-" + destino + "-" + kmRecorridos + "km.";
  }

  /**
   * Determina el tipo de ruta según la distancia.
   * 
   * @return "Corta" (<=250km), "Media" (251-500km) o "Larga" (>500km).
   */
  public String tipoRuta() {
    if (kmRecorridos <= 250) {
      return "Corta";
    } else if (kmRecorridos > 250 && kmRecorridos <= 500) {
      return "Media";
    } else {
      return "Larga";
    }
  }

  /**
   * Calcula el consumo estimado de combustible para esta ruta.
   * 
   * @return Litros consumidos estimados.
   */
  public double calcularConsumoEstimado() {
    return (vehiculoUsado.getConsumoLitros100km() * kmRecorridos) / 100;
  }

  public int getIdRuta() {
    return idRuta;
  }

  public void setIdRuta(int idRuta) {
    this.idRuta = idRuta;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    if (fecha != null) {
      this.fecha = fecha;
    } else {
      this.fecha = LocalDate.now();
    }
  }

  public String getOrigen() {
    return origen;
  }

  /**
   * Establece el origen de la ruta.
   * 
   * @param origen El origen (no puede ser nulo ni vacío).
   * @throws IllegalArgumentException Si el origen es inválido.
   */
  public void setOrigen(String origen) {
    if (origen != null && !origen.isEmpty()) {
      this.origen = origen;
    } else {
      throw new IllegalArgumentException("Error. El origen no puede ser nulo ni vacío.");
    }

  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public Vehiculo getVehiculoUsado() {
    return vehiculoUsado;
  }

  public void setVehiculoUsado(Vehiculo vehiculoUsado) {
    this.vehiculoUsado = vehiculoUsado;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public double getKmRecorridos() {
    return kmRecorridos;
  }

  /**
   * Establece los kilómetros recorridos.
   * 
   * @param kmRecorridos Los km (deben ser positivos).
   * @throws IllegalArgumentException Si los km no son positivos.
   */
  public void setKmRecorridos(double kmRecorridos) {
    if (kmRecorridos > 0) {
      this.kmRecorridos = kmRecorridos;
    } else {
      throw new IllegalArgumentException("Error. Los km sólo pueden ser positivos");
    }

  }

  public double getCargaTransportadaKg() {
    return cargaTransportadaKg;
  }

  /**
   * Establece la carga transportada en Kg.
   * 
   * @param cargaTransportadaKg La carga (debe ser positiva).
   * @throws IllegalArgumentException Si la carga no es positiva.
   */
  public void setCargaTransportadaKg(double cargaTransportadaKg) {
    if (cargaTransportadaKg > 0) {
      this.cargaTransportadaKg = cargaTransportadaKg;
    } else {
      throw new IllegalArgumentException("La carga debe ser positiva.");
    }
  }

  @Override
  public String toString() {
    return "Ruta [idRuta=" + idRuta + ", fecha=" + fecha + ", origen=" + origen + ", destino=" + destino
        + ", vehiculoUsado=" + vehiculoUsado.getMatricula() + ", empleado=" + empleado.getNombre() + ", kmRecorridos="
        + kmRecorridos
        + ", cargaTransportadaKg=" + cargaTransportadaKg + "]";
  }

}
