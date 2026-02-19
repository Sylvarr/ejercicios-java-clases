package excepciones;

/**
 * Excepción lanzada cuando se proporciona un socio no válido,
 * por ejemplo cuando el objeto {@code Socio} es {@code null}.
 */
public class SocioInvalidoException extends Exception {

  /**
   * Construye la excepción con el mensaje de error indicado.
   *
   * @param mensaje Descripción del motivo por el que el socio es inválido.
   */
  public SocioInvalidoException(String mensaje) {
    super(mensaje);
  }

}
