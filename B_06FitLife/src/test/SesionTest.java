package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import excepciones.ActividadInvalidaException;
import excepciones.SocioInvalidoException;
import modelos.javabean.ClaseDirigida;
import modelos.javabean.Sesion;
import modelos.javabean.Socio;

import java.time.LocalDate;

public class SesionTest {

  @Test
  void testConstructor_LanzaExcepcion_SiSocioEsNull() {

    ClaseDirigida actividadValida = new ClaseDirigida("C01", "Zumba", 10.0, "ProfeA", true);

    assertThrows(SocioInvalidoException.class, () -> {
      new Sesion(LocalDate.now(), null, actividadValida, 60);
    }, "Debería saltar SocioInvalidoException al intentar crear la sesión sin socio");
  }

  @Test
  void testConstructor_LanzaExcepcion_SiActividadEsNull() {
    Socio socioValido = new Socio("001", "Pencho");

    assertThrows(ActividadInvalidaException.class, () -> {
      new Sesion(LocalDate.now(), socioValido, null, 60);
    }, "Deberia saltar ActividadInvalidaException al intentar la sesión sin actividad");
  }
}