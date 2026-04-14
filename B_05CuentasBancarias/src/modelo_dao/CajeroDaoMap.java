package modelo_dao;

import java.util.HashMap;
import java.util.Map;

import excepciones.SaldoInsuficienteException;
import interfaces.CajeroDAO;

public class CajeroDaoMap implements CajeroDAO {

  Map<String, Double> cuentas = new HashMap<>();

  @Override
  public void ingresar(String iban, double cantidad) {

    if (cantidad < 0) {
      throw new IllegalArgumentException("La cantidad debe ser positiva.");
    }

    cuentas.put(iban, cuentas.getOrDefault(iban, 0.0) + cantidad);

    System.out.println("Ingreso realizado. Nuevo saldo de " + iban + ": " + cuentas.get(iban));

  }

  @Override
  public void retirar(String iban, double cantidad) throws SaldoInsuficienteException {

    Double SaldoActual = cuentas.get(iban);

    if (SaldoActual == null) {
      throw new IllegalArgumentException("Esta cuenta no existe.");
    }

    if (cantidad < 0) {
      throw new IllegalArgumentException("La cantidad debe ser positiva.");
    }

    if (cantidad > SaldoActual) {
      throw new SaldoInsuficienteException("Saldo insuficiente.");
    }

    cuentas.put(iban, SaldoActual - cantidad);

  }

  @Override
  public Double consultarSaldo(String iban) {
    return cuentas.get(iban);
  }

}
