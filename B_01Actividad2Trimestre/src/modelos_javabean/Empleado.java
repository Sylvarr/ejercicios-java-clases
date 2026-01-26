package modelos_javabean;

/**
 * Representa un empleado de la empresa de transporte.
 */
public class Empleado {

  private String dni;
  private String nombre;
  private String apellidos;
  private String email;
  private String genero;

  /**
   * Constructor completo para crear un Empleado.
   * 
   * @param dni       El DNI del empleado.
   * @param nombre    El nombre.
   * @param apellidos Los apellidos.
   * @param email     El correo electrónico.
   * @param genero    El género ('H' o 'M').
   */
  public Empleado(String dni, String nombre, String apellidos, String email, String genero) {
    setDni(dni);
    this.nombre = nombre;
    this.apellidos = apellidos;
    setEmail(email);
    setGenero(genero);
  }

  /**
   * Constructor vacío.
   */
  public Empleado() {

  }

  /**
   * Obtiene el nombre completo del empleado.
   * 
   * @return Nombre concatenado con apellidos.
   */
  public String nombreCompleto() {
    return nombre + " " + apellidos;
  }

  /**
   * Devuelve el literal del género del empleado.
   * 
   * @return "Hombre" o "Mujer" según el código de género.
   */
  public String literalGenero() {
    if (genero.equalsIgnoreCase("H")) {
      return "Hombre";
    } else {
      return "Mujer";
    }
  }

  public String getDni() {

    return dni;

  }

  /**
   * Establece el DNI del empleado.
   * 
   * @param dni El DNI (debe tener 9 caracteres).
   * @throws IllegalArgumentException Si la longitud del DNI es incorrecta.
   */
  public void setDni(String dni) {
    if (dni.length() == 9) {
      this.dni = dni;
    } else {
      throw new IllegalArgumentException("Error: DNI incorrecto. Debe tener 9 caracteres.");
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getEmail() {
    return email;
  }

  /**
   * Establece el correo electrónico.
   * 
   * @param email El email (debe contener '@').
   * @throws IllegalArgumentException Si el email no es válido.
   */
  public void setEmail(String email) {
    if (email.contains("@")) {
      this.email = email;
    } else {
      throw new IllegalArgumentException("Error. Por favor introduce un email válido (debe contener '@').");
    }

  }

  public String getGenero() {
    return genero;
  }

  /**
   * Establece el género del empleado.
   * 
   * @param genero 'H' para hombre, 'M' para mujer.
   * @throws IllegalArgumentException Si el género no es válido.
   */
  public void setGenero(String genero) {
    if (genero.equalsIgnoreCase("H") || genero.equalsIgnoreCase("M")) {
      this.genero = genero;
    } else {
      throw new IllegalArgumentException("Error. Genero inválido. Debe ser 'H' o 'M'.");
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
    Empleado other = (Empleado) obj;
    if (dni == null) {
      if (other.dni != null)
        return false;
    } else if (!dni.equals(other.dni))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", genero="
        + genero + "]";
  }

}
