package rock.paper.scissors.view;

import rock.paper.scissors.model.Event;
import rock.paper.scissors.model.Player;
import rock.paper.scissors.model.Session;

/**
 * The view interface for all the input/output interactions
 * 
 * @author Dimitris
 *
 */
public abstract interface View {

	//inputs
	public abstract Event inputEvent();
	public abstract int inputTotalGameSessionTimes();
	
	//outputs
	public abstract void outputTotalGameSessionTimes();
	public abstract void outputInitialGameInstructions();
	public abstract void outputGameInstructions();
	public abstract void outputGameOutcome(Player playerA, Player playerB);
	public abstract void outputMessageEventInputInvalid();
	public abstract void outputWelcomeMessage();
	public abstract void outputSessionHeader(int sessionId);
	public abstract void outputSessionOutcome(Session playerASession, Session playerBSession);
}
