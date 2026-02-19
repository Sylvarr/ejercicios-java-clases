package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelos.javabean.EntrenamientoLibre;

public class EntrenamientoLibreTest {

  private EntrenamientoLibre entrenamientoRunning;
  private EntrenamientoLibre entrenamientoCrossfit;

  @BeforeEach
  void setUp() {

    entrenamientoRunning = new EntrenamientoLibre("B002", "Running", 10, "Cardio");

    entrenamientoCrossfit = new EntrenamientoLibre("B003", "WOD", 15, "Crossfit");

  }

  @Test
  void testCalcularCaloriasQuemadas() {

    assertEquals(600, entrenamientoRunning.calcularCaloriasQuemadas(60));

  }

  @Test
  void testObtenerNivelIntensidad_EsCrossfit() {

    assertEquals("ALTO", entrenamientoCrossfit.obtenerNivelIntensidad(), "Si es Crossfit, la intensidad debe ser ALTA");
  }

  @Test
  void testObtenerNivelIntensidad_NoEsCrossfit() {

    assertEquals("VARIABLE", entrenamientoRunning.obtenerNivelIntensidad(),
        "Si no es Crossfit, la intensidad debe ser VARIABLE");
  }

}
