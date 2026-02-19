package excepciones;

/**
 * Excepción lanzada cuando se intenta registrar una sesión no válida,
 * por ejemplo cuando el objeto {@code Sesion} es {@code null}.
 */
public class SesionInvalidaException extends Exception {

  /**
   * Construye la excepción con el mensaje por defecto de la superclase.
   */
  public SesionInvalidaException() {
    super();
  }

  /**
   * Construye la excepción con el mensaje de error indicado.
   *
   * @param mensaje Descripción del motivo por el que la sesión es inválida.
   */
  public SesionInvalidaException(String mensaje) {
    super(mensaje);
  }
}