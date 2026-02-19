package interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excepciones.SesionInvalidaException;
import modelos.javabean.Sesion;
import modelos.javabean.Socio;

public interface IFitLifeDAO {

  /**
   * Registra una nueva sesión de entrenamiento en el sistema.
   * 
   * @param sesion El objeto de tipo Sesion que se desea añadir a la base de
   *               datos.
   * @throws SesionInvalidaException Si el objeto sesion proporcionado es nulo.
   */
  void registrarSesion(Sesion sesion) throws SesionInvalidaException;

  /**
   * Obtiene un conjunto de socios únicos extraídos de las sesiones registradas.
   * 
   * @return devuelve dicha lista.
   */
  Set<Socio> obtenerSociosActivos();

  /**
   * Suma las kcal de cada clase dirigida
   * 
   * @return Devuelve el número de kcal de todas las clases dirigidas.
   */
  double calcularCaloriasTotalesEnClasesDirigidas();

  /**
   * Cuenta el número de clases dirigidas impartidas por cada profesor
   * 
   * @return Devuelve un mapa cuya clave es el nombre del profesor y el valor es
   *         la cantidad total de clases que ha impartido.
   */
  Map<String, Long> contarClasesPorProfesor();

  /**
   * grupa las sesiones de tipo Entrenamiento Libre según su fecha
   * 
   * @return Devuelve un mapa cuya clave es una fecha y su valor es un ArrayList
   *         de sesiones.
   */
  Map<LocalDate, List<Sesion>> agruparEntrenamientosLibresPorFecha();

  /**
   * Recupera las sesiones que se consideran extremas, es decir, aquellas que
   * superan una duración mínima y tienen una intensidad "ALTO".
   * 
   * @param minutosMinimos La cantidad mínima de minutos que debe haber durado la
   *                       sesión.
   * @return Una lista con las sesiones que cumplen ambas condiciones.
   */
  List<Sesion> sesionesExtremas(int minutosMinimos);

}
