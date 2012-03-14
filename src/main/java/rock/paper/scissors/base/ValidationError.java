package rock.paper.scissors.base;

/**
 * Grouping together the application errors
 * 
 * @author Dimitris
 *
 */
public enum ValidationError {
	ERROR_IN_HUMAN_INTERACTOR("There was an error while loading the human interactor"),
	ERROR_IN_COMPUTER_INTERACTOR("There was an error while loading the computer interactor"),
	INPUT_NEEDS_TO_BE_INTEGER("The input is not a valid positive integer. Please try again:"),
	INPUT_NEEDS_TO_BE_POSITIVE_INTEGER("The input needs to be a positive integer. Please try again:"),
	ERROR_DEFINING_A_VALID_EVENT("This needs to be a valid Rock-Paper-Scissors event! Please try again:");
	
	private String message;
	
	private ValidationError(String message){
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message.toString();
	}
}
