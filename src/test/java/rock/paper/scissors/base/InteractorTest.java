package rock.paper.scissors.base;

import org.junit.Test;

import rock.paper.scissors.base.RockPaperScissorsException;
import rock.paper.scissors.model.ComputerPlayer;
import rock.paper.scissors.model.HumanPlayer;
import rock.paper.scissors.model.Player;

public class InteractorTest {

	@Test(expected=RockPaperScissorsException.class)
	public void setWrongHumanInteractor() throws RockPaperScissorsException{
		Player humanPlayer = new HumanPlayer();
		humanPlayer.setInteractor(new Object());
	}

	@Test(expected=RockPaperScissorsException.class)
	public void setWrongComputerInteractor() throws RockPaperScissorsException{
		Player computerPlayer = new ComputerPlayer();
		computerPlayer.setInteractor(new Object());
	}
}
