package modelo_javabean;

public class Cuenta {

  private String iban;
  private double saldo;

  public Cuenta(String iban, int saldo) {
    this.iban = iban;
    this.saldo = saldo;
  }

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  @Override
  public String toString() {
    return "Cuenta [iban=" + iban + ", saldo=" + saldo + "]";
  }

}
