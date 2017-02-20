package exceptions;

public class InvalidRomanNumeralError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4843813974299885444L;

	public InvalidRomanNumeralError(String message){
		super(message);
	}
}
