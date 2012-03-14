package rock.paper.scissors.model;

import rock.paper.scissors.base.RockPaperScissorsException;

public abstract interface IGame {

	public abstract void performGameSession() throws RockPaperScissorsException;
	public abstract boolean isGameSessionsOver();
}