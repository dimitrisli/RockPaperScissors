package rock.paper.scissors.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import rock.paper.scissors.base.PlayerType;
import rock.paper.scissors.base.RockPaperScissorsException;
import rock.paper.scissors.base.ValidationError;

public class ComputerPlayer extends Player {

	private static final List<Event> eventCachedList = Collections.unmodifiableList(Arrays.asList(Event.values()));

	private Random randomBase;
	
	@Override
	public Event decideCurrentHandEvent() {
		int randomInt = randomBase.nextInt(eventCachedList.size());
		return eventCachedList.get(randomInt);
	}

	@Override
	public void setInteractor(Object computerInteractor) throws RockPaperScissorsException {
		if(!(computerInteractor instanceof Random)){
			throw new RockPaperScissorsException(ValidationError.ERROR_IN_COMPUTER_INTERACTOR);
		}
		addPlayerTypeNature();
		randomBase = (Random) computerInteractor;
	}
	
	@Override
	protected void addPlayerTypeNature(){
		this.playerType = PlayerType.COMPUTER;
	}
}
