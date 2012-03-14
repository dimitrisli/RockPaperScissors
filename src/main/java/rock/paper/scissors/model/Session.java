package rock.paper.scissors.model;

import rock.paper.scissors.base.PlayerType;

/**
 * Useful interface not to rely on the Player.PlayerSession
 * when needing to define/expose the type of the session.
 * 
 * @author Dimitris
 *
 */
public abstract interface Session {

	public abstract PlayerType getPlayerType();
	public abstract int getSessionRound();
	public abstract Event getSessionPlayerEvent();
	public abstract Outcome getSessionPlayerOutcome();
}
