package interfaces;

import excepciones.SaldoInsuficienteException;

public interface CajeroDAO {

  void ingresar(String iban, double cantidad);

  void retirar(String iban, double cantidad) throws SaldoInsuficienteException;

  Double consultarSaldo(String iban);

}
