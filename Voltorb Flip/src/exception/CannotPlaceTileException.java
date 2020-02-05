package exception;

public class CannotPlaceTileException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -3110386595928317601L;

  public CannotPlaceTileException() {
    super("Cannot find a place for the given tile.");
  }
}
