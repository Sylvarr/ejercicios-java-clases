package A_01PrimerEjercicio.modelos;

public class Direccion {

  private String calle;
  private String ciudad;

  // Empty constructor
  public Direccion() {

  };

  // Contrusctor
  public Direccion(String calle, String ciudad) {
    this.calle = calle;
    this.ciudad = ciudad;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  @Override
  public String toString() {
    return "Direccion [calle=" + calle + ", ciudad=" + ciudad + "]";
  }

}
