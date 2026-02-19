package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.IFitLifeDAO;
import modelos.DAO.FitLifeDAOImpl;
import modelos.javabean.ClaseDirigida;
import modelos.javabean.EntrenamientoLibre;
import modelos.javabean.Sesion;
import modelos.javabean.Socio;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FitLifeDAOImplTest {

  // Declaramos el DAO y las variables que vamos a usar en varios tests
  private IFitLifeDAO dao;
  private Socio socio1;
  private Socio socio2;
  private ClaseDirigida clase1;
  private EntrenamientoLibre libre1;

  @BeforeEach
  void setUp() throws Exception {

    // 1. Inicializamos un DAO limpio para cada prueba
    dao = new FitLifeDAOImpl();

    // 2. Creación de socios
    socio1 = new Socio("001A", "Pencho");
    socio2 = new Socio("002A", "Roberto");

    // 3. Creación de actividades
    clase1 = new ClaseDirigida("A001", "Pilates", 10, "Juan", true);
    libre1 = new EntrenamientoLibre("B001", "Running", 15, "Cardio");

    // 4. Creación de sesiones
    Sesion sesion1 = new Sesion(LocalDate.now(), socio1, clase1, 60);
    Sesion sesion2 = new Sesion(LocalDate.now().minusDays(3), socio1, libre1, 90);
    Sesion sesion3 = new Sesion(LocalDate.now().minusDays(1), socio2, clase1, 45);

    // Registro sesiones
    dao.registrarSesion(sesion1);
    dao.registrarSesion(sesion2);
    dao.registrarSesion(sesion3);
  }

  @Test
  void testObtenerSociosActivos() {

    Set<Socio> socios = dao.obtenerSociosActivos();

    assertEquals(2, socios.size());

  }

  @Test
  void testCalcularCaloriasTotalesEnClasesDirigidas() {

    double kcalTotales = dao.calcularCaloriasTotalesEnClasesDirigidas();

    assertEquals(1150, kcalTotales);

  }

  @Test
  void testContarClasesPorProfesor() {

    Map<String, Long> mapaProfesores = dao.contarClasesPorProfesor();

    assertEquals(2L, mapaProfesores.get("Juan"));

  }

  @Test
  void testAgruparEntrenamientosLibresPorFecha() {

    Map<LocalDate, List<Sesion>> mapaEntrenamientos = dao.agruparEntrenamientosLibresPorFecha();

    assertEquals(1, mapaEntrenamientos.get(LocalDate.now().minusDays(3)).size());

  }

  @Test
  void testSesionesExtremas() {

    List<Sesion> listaSesiones = dao.sesionesExtremas(5);

    assertEquals(2, listaSesiones.size());
  }
}