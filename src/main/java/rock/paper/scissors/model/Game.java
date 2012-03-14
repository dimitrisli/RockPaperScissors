package rock.paper.scissors.model;

import rock.paper.scissors.base.RockPaperScissorsException;
import rock.paper.scissors.view.View;

/**
 * The Game class
 * 
 * @author Dimitris
 *
 */
public class Game implements IGame {

	private int sessionCounter;
	private int sessionTimesToComplete;
	private Player playerA;
	private Player playerB;
	private View consoleView;
	
	public Game(Player playerA, Player playerB, int sessionTimesToComplete, View consoleView){
		this.playerA = playerA;
		this.playerB = playerB;
		this.consoleView = consoleView;
		this.sessionTimesToComplete = sessionTimesToComplete;
	}
	
	
	@Override
	public void performGameSession() throws RockPaperScissorsException{
		gameSessionStarted();
		gamersDecideSessionMoves();
		consoleView.outputSessionOutcome(playerA.getPlayerSessions().get(sessionCounter), playerB.getPlayerSessions().get(sessionCounter));
	}

	public boolean isGameSessionsOver(){
		return sessionCounter == sessionTimesToComplete;
	}
	
	public void getOverallGameWinner(){
		consoleView.outputGameOutcome(playerA, playerB);
	}
	
	private void gamersDecideSessionMoves() throws RockPaperScissorsException{
		consoleView.outputSessionHeader(sessionCounter);
		Event currentEventDecisionPlayerA = playerA.decideCurrentHandEvent();
		Event currentEventDecisionPlayerB = playerB.decideCurrentHandEvent();
		//create player sessions
		Outcome playerASessionOutcome = currentEventDecisionPlayerA.tailoredCompareTo(currentEventDecisionPlayerB);
		playerA.newPlayerSession(sessionCounter,currentEventDecisionPlayerA, playerASessionOutcome);
		playerB.newPlayerSession(sessionCounter,currentEventDecisionPlayerB,playerASessionOutcome.oppositOutcome());
	}

	private void gameSessionStarted(){
		sessionCounter++;
	}
}
