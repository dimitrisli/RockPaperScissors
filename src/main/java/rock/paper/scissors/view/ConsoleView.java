package rock.paper.scissors.view;

import java.util.Scanner;

import rock.paper.scissors.base.ValidationError;
import rock.paper.scissors.model.Event;
import rock.paper.scissors.model.Outcome;
import rock.paper.scissors.model.Player;
import rock.paper.scissors.model.Session;

/**
 * The ConsoleView that captures all the input/output interactions
 * on the command-line.
 * 
 * @author Dimitris
 *
 */
public class ConsoleView implements View {

	private Scanner scanner;
	
	public ConsoleView(){
		this.scanner = new Scanner(System.in);
	};
	
	@Override
	public Event inputEvent() {
		outputHumanPlayerMessage();
		String inputStr = null; 
		inputStr = scanner.next();
		while(inputStr == null || Event.getEventByNameOrGesture(inputStr)==null){
			System.out.println(ValidationError.ERROR_DEFINING_A_VALID_EVENT);
			inputStr = scanner.next();
		}
		Event input = Event.getEventByNameOrGesture(inputStr);
		outputNewLine();
		return input;
	}

	@Override
	public int inputTotalGameSessionTimes() {
		int input = -1;
		while(input <= 0){
			try{
				String inputStr = scanner.next();
				input = Integer.parseInt(inputStr);
				if(input <= 0){
					System.out.println(ValidationError.INPUT_NEEDS_TO_BE_POSITIVE_INTEGER);
				}
			}catch (NumberFormatException nfe) {
				System.out.println(ValidationError.INPUT_NEEDS_TO_BE_INTEGER);
			}
		}
		outputNewLine();
		return input;
	}
	
	@Override
	public void outputTotalGameSessionTimes(){
		System.out.print("Please insert the total sessions number you wish this game to have:");
		outputNewLine();
	}
	
	@Override
	public void outputInitialGameInstructions(){
		System.out.println("In the following game sessions, ");
		outputGameInstructions();
		outputNewLine();
	}
	
	@Override
	public void outputGameInstructions(){
		System.out.println("please enter one of the following three names or gestures (no case sensitivity): ");
		System.out.println("FIST or ROCK / OPEN_HAND or PAPER / TWO_FINGERS or SCISSORS.");
		System.out.print("(please press any key to continue)");
		scanner.next();
	}

	@Override
	public void outputMessageEventInputInvalid(){
		System.out.println("Your entry was not one of the expected ones, ");
		outputGameInstructions();
	}
	
	@Override
	public void outputWelcomeMessage(){
		outputRulerLine("Rock - Paper - Scissors");
		System.out.println("Rock - Paper - Scissors");
		outputRulerLine("Rock - Paper - Scissors");
		outputNewLine();
		System.out.println("Welcome to the Rock - Paper - Scissors Game!");
		outputNewLine();
	}
	
	@Override
	public void outputSessionOutcome(Session playerASession, Session playerBSession){
		System.out.println("Session "+playerASession.getSessionRound()+" Results");
		outputRulerLine("Session X Results");
		System.out.println(playerASession.getPlayerType().toString()+" player: "+playerASession.getSessionPlayerEvent().toString()+"\t"+
						   playerBSession.getPlayerType().toString()+" player: "+playerBSession.getSessionPlayerEvent().toString());
		if(playerASession.getSessionPlayerOutcome().equals(Outcome.DRAW)){
			System.out.println("Session winner: \t Draw");
		} else if(playerASession.getSessionPlayerOutcome().equals(Outcome.WIN)){
			System.out.println("Session winner: \t"+playerASession.getPlayerType().toString()+" player");
		} else if(playerBSession.getSessionPlayerOutcome().equals(Outcome.WIN)){
			System.out.println("Session winner: \t"+playerBSession.getPlayerType().toString()+" player");
		}
		outputNewLine();
	}

	@Override
	public void outputGameOutcome(Player playerA, Player playerB){
		int playerAScore = playerA.getTotalGameSessionsScore();
		int playerBScore = playerB.getTotalGameSessionsScore();
		outputRulerLine("Game Winner is the XXXXXXXXX player");
		if(playerAScore > playerBScore){
			System.out.println("Game Winner is the "+playerA.playerType.toString()+" player!");
		} else if(playerAScore < playerBScore){
			System.out.println("Game Winner is the "+playerB.playerType.toString()+" player!");
		} else {
			System.out.println("The game outcome was a DRAW!");
		}
		outputRulerLine("Game Winner is the XXXXXXXXX player");
	}
	
	@Override
	public void outputSessionHeader(int sessionId){
		System.out.println("Session "+sessionId);
		outputRulerLine("Session X");
		outputNewLine();
	}
	
	
	private void outputHumanPlayerMessage(){
		System.out.print("Please insert your choice (name or gesture):");
		outputNewLine();
	}
	
	private void outputRulerLine(String str){
		for(int i=0; i< str.length(); i++){
			System.out.print("=");
		}
		outputNewLine();
	}
	
	private void outputNewLine(){
		System.out.println();
	}
}
