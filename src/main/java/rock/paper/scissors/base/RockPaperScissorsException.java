package rock.paper.scissors.base;

/**
 * The application specific exception
 * 
 * @author Dimitris
 *
 */
public class RockPaperScissorsException extends Exception{

	private static final long serialVersionUID = 1L;

	public RockPaperScissorsException(ValidationError validationError){
		super(validationError.toString());
	}
}
