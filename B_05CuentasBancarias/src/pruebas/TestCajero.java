package pruebas;

import interfaces.CajeroDAO;
import modelo_dao.CajeroDaoMap;
import excepciones.SaldoInsuficienteException;

public class TestCajero {

  public static void main(String[] args) {

    CajeroDAO banco = new CajeroDaoMap();

    System.out.println("--- PRUEBA 1: Ingreso ---");
    banco.ingresar("ES21-111", 500.0);

    try {
      System.out.println("\n--- PRUEBA 2: Retirar más de lo que hay ---");
      banco.retirar("ES21-111", 600.0);

    } catch (SaldoInsuficienteException e) {
      System.out.println("⚠️ ERROR BANCARIO: " + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("❌ ERROR DE DATOS: " + e.getMessage());
    }

    try {
      System.out.println("\n--- PRUEBA 3: Retirar de cuenta que no existe ---");
      banco.retirar("ES99-999", 10.0);

    } catch (SaldoInsuficienteException e) {
      System.out.println("⚠️ ERROR BANCARIO: " + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("❌ ERROR DE DATOS: " + e.getMessage());
    }

    try {
      System.out.println("\n--- PRUEBA 4: Meter dinero negativo ---");
      banco.ingresar("ES21-111", -50.0);

    } catch (IllegalArgumentException e) {
      System.out.println("❌ ERROR DE DATOS: " + e.getMessage());
    }

    System.out.println("\n--- RESUMEN FINAL ---");
    System.out.println("Saldo final ES21-111: " + banco.consultarSaldo("ES21-111") + "€");
  }
}