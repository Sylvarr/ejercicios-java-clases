package modelos_dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IGestionRutas;
import modelos_javabean.Ruta;

/**
 * Implementación de la interfaz IGestionRutas.
 * Gestiona una colección de rutas utilizando un ArrayList en memoria.
 */
public class GestionRutas implements IGestionRutas {

  private List<Ruta> rutas;

  /**
   * Constructor que inicializa la lista de rutas vacía.
   */
  public GestionRutas() {
    rutas = new ArrayList<>();
  }

  @Override
  public void addRuta(Ruta ruta) {
    rutas.add(ruta);
  }

  @Override
  public void eliminarRuta(Ruta ruta) {

    boolean borrado = rutas.remove(ruta);

    if (borrado) {
      System.out.println("Ruta eliminada correctamente.");
    } else {
      System.out.println("No se encontró esa ruta.");
    }
  }

  @Override
  public void eliminarRuta(int idRuta) {

    Ruta rutaABorrar = null;

    for (Ruta ruta : rutas) {
      if (ruta.getIdRuta() == idRuta) {
        rutaABorrar = ruta;
        break;
      }
    }

    if (rutaABorrar != null) {
      rutas.remove(rutaABorrar);
      System.out.println("Ruta con id " + idRuta + " eliminada.");
    } else {
      System.out.println("No se encontró ninguna ruta con id " + idRuta);
    }

  }

  @Override
  public List<Ruta> rutasPorEmpleado(String dni) {
    List<Ruta> rutasEncontradas = new ArrayList<>();

    for (Ruta ruta : rutas) {
      if (ruta.getEmpleado() != null && ruta.getEmpleado().getDni() != null
          && ruta.getEmpleado().getDni().equals(dni)) {
        rutasEncontradas.add(ruta);
      }
    }

    return rutasEncontradas;

  }

  @Override
  public List<Ruta> rutasPorVehiculo(String matricula) {

    List<Ruta> rutasEncontradas = new ArrayList<>();

    for (Ruta ruta : rutas) {
      if (ruta.getVehiculoUsado() != null && ruta.getVehiculoUsado().getMatricula() != null
          && ruta.getVehiculoUsado().getMatricula().equals(matricula)) {
        rutasEncontradas.add(ruta);
      }
    }

    return rutasEncontradas;
  }

  @Override
  public List<Ruta> rutasPorDestino(String destino) {
    List<Ruta> rutasEncontradas = new ArrayList<>();

    for (Ruta ruta : rutas) {
      if (ruta.getDestino() != null && ruta.getDestino().equals(destino)) {
        rutasEncontradas.add(ruta);
      }
    }
    return rutasEncontradas;
  }

  @Override
  public List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin) {
    List<Ruta> rutaEncontrada = new ArrayList<>();

    for (Ruta ruta : rutas) {
      if (ruta.getFecha() != null && !ruta.getFecha().isBefore(inicio) && !ruta.getFecha().isAfter(fin)) {
        rutaEncontrada.add(ruta);
      }
    }

    return rutaEncontrada;
  }

  @Override
  public Map<String, Long> totalKmPorVehiculo() {
    Map<String, Long> mapaKm = new HashMap<>();

    for (Ruta ruta : rutas) {
      if (ruta.getVehiculoUsado() != null && ruta.getVehiculoUsado().getMatricula() != null) {
        String matricula = ruta.getVehiculoUsado().getMatricula();
        long kmRuta = (long) ruta.getKmRecorridos();
        if (mapaKm.containsKey(matricula)) {
          long loQueTenia = mapaKm.get(matricula);
          long nuevoTotal = loQueTenia + kmRuta;
          mapaKm.put(matricula, nuevoTotal);
        } else {
          mapaKm.put(matricula, kmRuta);
        }
      }
    }
    return mapaKm;
  }

  @Override
  public Map<String, Long> totalKmPorTipoVehiculo() {

    Map<String, Long> mapaTipos = new HashMap<>();

    for (Ruta ruta : rutas) {
      if (ruta.getVehiculoUsado() != null) {
        String tipo;
        if (ruta.getVehiculoUsado() instanceof modelos_javabean.Camion) {
          tipo = "CAMION";
        } else {
          tipo = "FURGONETA";
        }
        long kmRuta = (long) ruta.getKmRecorridos();

        if (mapaTipos.containsKey(tipo)) {
          long acumulado = mapaTipos.get(tipo);
          mapaTipos.put(tipo, acumulado + kmRuta);
        } else {
          mapaTipos.put(tipo, kmRuta);
        }
      }
    }
    return mapaTipos;
  }

}
