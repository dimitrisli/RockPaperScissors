package rock.paper.scissors.service;

import java.util.Random;

import rock.paper.scissors.base.RockPaperScissorsException;
import rock.paper.scissors.model.ComputerPlayer;
import rock.paper.scissors.model.Game;
import rock.paper.scissors.model.HumanPlayer;
import rock.paper.scissors.model.IGame;
import rock.paper.scissors.model.Player;
import rock.paper.scissors.view.ConsoleView;
import rock.paper.scissors.view.View;

/**
 * The main entry point
 * 
 * @author Dimitris
 *
 */
public class RockPaperScissors {

	public static final Random random = new Random();
	
	public static void main(String[] args) {
		
		try{
			
			//our view
			View consoleView = new ConsoleView();
			
			//our players
			Player humanPlayer = new HumanPlayer();
			Player computerPlayer = new ComputerPlayer();
			
			//injecting interactors
			humanPlayer.setInteractor(consoleView);
			computerPlayer.setInteractor(random);
			
			//welcome message
			consoleView.outputWelcomeMessage();
			
			//how long will the game last
			int totalGameSessionTimes;
			consoleView.outputTotalGameSessionTimes();
			totalGameSessionTimes = consoleView.inputTotalGameSessionTimes();
			
			//new game
			consoleView.outputInitialGameInstructions();
			IGame game = new Game(humanPlayer, computerPlayer, totalGameSessionTimes, consoleView);
			
			//game sessions
			while(!game.isGameSessionsOver()){
				game.performGameSession();
			}
			
			//game winner
			consoleView.outputGameOutcome(humanPlayer,computerPlayer);
		
		}catch (RockPaperScissorsException rpse) {
			System.out.println(rpse.getMessage());
		}
	
	}
}
