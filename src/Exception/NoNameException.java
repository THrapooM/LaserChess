package Exception;

public class NoNameException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

    public NoNameException(String message){
        this.message=message;
    }
    public String getMessage() {
    	return message;
    }
}
