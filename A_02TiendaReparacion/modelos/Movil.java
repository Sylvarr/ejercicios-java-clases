package A_02TiendaReparacion.modelos;

public class Movil {

  private String modelo;
  private double precio;
  private Bateria bateria;

  // Constructores vacios y llenos
  public Movil() {

  }

  public Movil(String modelo, double precio, Bateria bateria) {
    this.modelo = modelo;
    this.precio = precio;
    this.bateria = bateria;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getModelo() {
    return modelo;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public double getPrecio() {
    return precio;
  }

  public void setBateria(Bateria bateria) {
    this.bateria = bateria;
  }

  public Bateria getBateria() {
    return bateria;
  }

  @Override
  public String toString() {
    return "Movil [modelo=" + modelo + ", precio=" + precio + ", bateria=" + bateria + "]";
  }

}