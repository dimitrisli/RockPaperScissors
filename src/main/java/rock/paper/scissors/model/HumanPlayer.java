package rock.paper.scissors.model;

import rock.paper.scissors.base.PlayerType;
import rock.paper.scissors.base.RockPaperScissorsException;
import rock.paper.scissors.base.ValidationError;
import rock.paper.scissors.view.ConsoleView;

public class HumanPlayer extends Player{

	private ConsoleView humanInteractor;
	
	@Override
	public Event decideCurrentHandEvent() {
		return humanInteractor.inputEvent();
	}

	@Override
	public void setInteractor(Object humanInteractor) throws RockPaperScissorsException {
		if(!(humanInteractor instanceof ConsoleView)){
			throw new RockPaperScissorsException(ValidationError.ERROR_IN_HUMAN_INTERACTOR);
		}
		addPlayerTypeNature();
		this.humanInteractor = (ConsoleView) humanInteractor;
	}

	@Override
	protected void addPlayerTypeNature(){
		this.playerType = PlayerType.HUMAN;
	}
}
