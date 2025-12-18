package A_02TiendaReparacion.modelos;

public class Bateria {

  // Variables
  private int mAh;
  private String marca;

  // Constructores vacio y lleno;
  public Bateria() {

  }

  public Bateria(int mAh, String marca) {
    this.mAh = mAh;
    this.marca = marca;
  }

  public int getmAh() {
    return mAh;
  }

  public void setmAh(int mAh) {
    this.mAh = mAh;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  @Override
  public String toString() {
    return "Bateria [mAh=" + mAh + ", marca=" + marca + "]";
  }

}
