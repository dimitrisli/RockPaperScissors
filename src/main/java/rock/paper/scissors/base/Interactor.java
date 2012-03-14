package rock.paper.scissors.base;

/**
 * Interface to inject the interactor
 * 
 * @author Dimitris
 *
 */
public abstract interface Interactor {
	
	public abstract void setInteractor(Object interactorObj) throws RockPaperScissorsException;
}
