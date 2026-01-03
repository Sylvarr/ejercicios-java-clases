package A_05Banco.modelos;

public class CuentaBancaria {

  private String iban;
  private String titular;
  private double saldo;
  private static int contador;

  private void crearIban() {
    contador++;
    iban = "ES00" + contador;
  }

  public CuentaBancaria(String titular, double saldoInicial) {
    this.titular = titular;
    saldo = saldoInicial;
    crearIban();
  }

  public CuentaBancaria(String titular) {
    this.titular = titular;
    saldo = 0.0;
    crearIban();
  }

  public String getTitular() {
    return titular;
  }

  public String getIban() {
    return iban;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public void ingresar(double ingreso) {
    saldo += ingreso;
    System.out.println("Su nuevo saldo es: " + saldo);
  }

  public void retirar(double retiro) {

    if (saldo < retiro) {
      System.out.println("Saldo insuficiente");
    } else {
      saldo -= retiro;
    }

  }

  @Override
  public String toString() {
    return "CuentaBancaria [iban=" + iban + ", titular=" + titular + ", saldo=" + saldo + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((titular == null) ? 0 : titular.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CuentaBancaria other = (CuentaBancaria) obj;
    if (titular == null) {
      if (other.titular != null)
        return false;
    } else if (!titular.equals(other.titular))
      return false;
    return true;
  }

}
