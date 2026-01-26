package interfaces;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import modelos_javabean.Ruta;

/**
 * Interfaz que define las operaciones disponibles para la gestión de rutas.
 */
public interface IGestionRutas {

  /**
   * Añade una nueva ruta a la gestión.
   * 
   * @param ruta La ruta a añadir.
   */
  void addRuta(Ruta ruta);

  /**
   * Elimina una ruta específica.
   * 
   * @param ruta La ruta a eliminar.
   */
  void eliminarRuta(Ruta ruta);

  /**
   * Elimina una ruta por su identificador.
   * 
   * @param idRuta El identificador de la ruta a eliminar.
   */
  void eliminarRuta(int idRuta);

  /**
   * Busca rutas asignadas a un empleado específico.
   * 
   * @param dni El DNI del empleado.
   * @return Lista de rutas del empleado.
   */
  List<Ruta> rutasPorEmpleado(String dni);

  /**
   * Busca rutas realizadas con un vehículo específico.
   * 
   * @param matricula La matrícula del vehículo.
   * @return Lista de rutas con ese vehículo.
   */
  List<Ruta> rutasPorVehiculo(String matricula);

  /**
   * Busca rutas que tienen un destino específico.
   * 
   * @param destino El destino a buscar.
   * @return Lista de rutas con ese destino.
   */
  List<Ruta> rutasPorDestino(String destino);

  /**
   * Busca rutas que se encuentran dentro de un intervalo de fechas.
   * 
   * @param inicio La fecha de inicio.
   * @param fin    La fecha de fin.
   * @return Lista de rutas en el intervalo.
   */
  List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin);

  /**
   * Calcula el total de kilómetros recorridos por cada vehículo.
   * 
   * @return Mapa donde la clave es la matrícula y el valor son los kilómetros
   *         totales.
   */
  Map<String, Long> totalKmPorVehiculo();

  /**
   * Calcula el total de kilómetros recorridos por tipo de vehículo (Camión o
   * Furgoneta).
   * 
   * @return Mapa donde la clave es el tipo de vehículo y el valor son los
   *         kilómetros totales.
   */
  Map<String, Long> totalKmPorTipoVehiculo();
}
