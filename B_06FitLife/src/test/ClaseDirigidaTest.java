package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.javabean.ClaseDirigida;

public class ClaseDirigidaTest {

  private ClaseDirigida claseConReserva;
  private ClaseDirigida claseSinReserva;

  @BeforeEach
  void setUp() {
    // Se ejecuta antes de cada test
    claseConReserva = new ClaseDirigida("C01", "Zumba", 10.0, "ProfeA", true);
    claseSinReserva = new ClaseDirigida("C02", "Pilates", 8.0, "ProfeB", false);
  }

  @Test
  void testCalcularCaloriasQuemadas() {
    double resultado = claseConReserva.calcularCaloriasQuemadas(60);
    assertEquals(650, resultado);
  }

  @Test
  void testObtenerNivelIntensidad_conReserva() {
    assertEquals("ALTO", claseConReserva.obtenerNivelIntensidad());
  }

  @Test
  void testObtenerNivelIntensidad_sinReserva() {
    assertEquals("MEDIO", claseSinReserva.obtenerNivelIntensidad());
  }
}
