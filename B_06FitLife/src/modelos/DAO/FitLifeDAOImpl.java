package modelos.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import excepciones.SesionInvalidaException;
import interfaces.IFitLifeDAO;
import modelos.javabean.Actividad;
import modelos.javabean.ClaseDirigida;
import modelos.javabean.EntrenamientoLibre;
import modelos.javabean.Sesion;
import modelos.javabean.Socio;

/**
 * Implementación del repositorio de datos de FitLife.
 * <p>
 * Almacena las sesiones de entrenamiento en memoria mediante un
 * {@link java.util.ArrayList} e implementa todas las consultas definidas
 * en {@link IFitLifeDAO}.
 * </p>
 */
public class FitLifeDAOImpl implements IFitLifeDAO {

  /** Lista interna que almacena todas las sesiones registradas. */
  private List<Sesion> sesiones;

  /**
   * Construye un nuevo repositorio vacío.
   */
  public FitLifeDAOImpl() {
    this.sesiones = new ArrayList<>();
  }

  /**
   * {@inheritDoc}
   *
   * @throws SesionInvalidaException Si {@code sesion} es {@code null}.
   */
  @Override
  public void registrarSesion(Sesion sesion) throws SesionInvalidaException {

    if (sesion == null) {
      throw new SesionInvalidaException("Error. La sesión no puede ser nula.");
    } else {
      sesiones.add(sesion);
    }

  }

  /**
   * {@inheritDoc}
   * <p>
   * Recorre todas las sesiones y añade cada socio a un {@link java.util.HashSet}
   * para garantizar la unicidad.
   * </p>
   */
  @Override
  public Set<Socio> obtenerSociosActivos() {
    Set<Socio> socios = new HashSet<>();

    for (Sesion sesion : sesiones) {
      socios.add(sesion.getSocio());
    }

    return socios;

  }

  /**
   * {@inheritDoc}
   * <p>
   * Solo se tienen en cuenta las sesiones cuya actividad sea una
   * {@link ClaseDirigida}. Las calorías se calculan llamando a
   * {@link ClaseDirigida#calcularCaloriasQuemadas(int)} con la duración
   * de cada sesión.
   * </p>
   */
  @Override
  public double calcularCaloriasTotalesEnClasesDirigidas() {
    double caloriasTotales = 0.0;
    for (Sesion sesion : sesiones) {
      Actividad actividad = sesion.getActividadRealizada();
      if (actividad instanceof ClaseDirigida) {
        ClaseDirigida claseDirigida = (ClaseDirigida) actividad;
        caloriasTotales += claseDirigida.calcularCaloriasQuemadas(sesion.getDuracionMinutos());
      }
    }

    return caloriasTotales;
  }

  /**
   * {@inheritDoc}
   * <p>
   * Itera las sesiones filtrando las de tipo {@link ClaseDirigida} y acumula
   * el contador de clases por nombre de profesor en un {@link java.util.HashMap}.
   * </p>
   */
  @Override
  public Map<String, Long> contarClasesPorProfesor() {
    Map<String, Long> mapaClases = new HashMap<>();

    for (Sesion sesion : sesiones) {
      Actividad actividad = sesion.getActividadRealizada();
      if (actividad instanceof ClaseDirigida) {
        ClaseDirigida claseDirigida = (ClaseDirigida) actividad;
        String profe = claseDirigida.getNombreProfesor();
        mapaClases.put(profe, mapaClases.getOrDefault(profe, 0L) + 1L);
      }
    }

    return mapaClases;

  }

  /**
   * {@inheritDoc}
   * <p>
   * Filtra las sesiones de tipo {@link EntrenamientoLibre} y las agrupa por
   * fecha en un {@link java.util.HashMap}. Si ya existe una entrada para esa
   * fecha, la sesión se añade a la lista existente; en caso contrario se crea
   * una nueva lista.
   * </p>
   */
  @Override
  public Map<LocalDate, List<Sesion>> agruparEntrenamientosLibresPorFecha() {

    Map<LocalDate, List<Sesion>> mapaSesiones = new HashMap<>();

    for (Sesion sesion : sesiones) {
      Actividad actividad = sesion.getActividadRealizada();
      if (actividad instanceof EntrenamientoLibre) {
        LocalDate fecha = sesion.getFecha();
        if (mapaSesiones.containsKey(fecha)) {
          mapaSesiones.get(fecha).add(sesion);
        } else {
          List<Sesion> listaSesiones = new ArrayList<>();
          listaSesiones.add(sesion);
          mapaSesiones.put(fecha, listaSesiones);
        }
      }

    }
    return mapaSesiones;
  }

  /**
   * {@inheritDoc}
   * <p>
   * Una sesión se considera extrema si su duración es estrictamente mayor que
   * {@code minutosMinimos} y el nivel de intensidad de su actividad es
   * {@code "ALTO"}.
   * </p>
   */
  @Override
  public List<Sesion> sesionesExtremas(int minutosMinimos) {

    List<Sesion> sesionesExtremas = new ArrayList<>();

    for (Sesion sesion : sesiones) {
      if (sesion.getDuracionMinutos() > minutosMinimos) {
        String intensidad = sesion.getActividadRealizada().obtenerNivelIntensidad();
        if ("ALTO".equals(intensidad)) {
          sesionesExtremas.add(sesion);
        }
      }
    }
    return sesionesExtremas;
  }

}
