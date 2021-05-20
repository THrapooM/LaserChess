package Exception;

public class NoSelectedChessPieceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public NoSelectedChessPieceException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
