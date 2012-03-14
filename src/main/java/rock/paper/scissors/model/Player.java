package rock.paper.scissors.model;

import java.util.Map;
import java.util.TreeMap;

import rock.paper.scissors.base.Interactor;
import rock.paper.scissors.base.PlayerType;
import rock.paper.scissors.base.RockPaperScissorsException;

/**
 * The player abstract class. It includes a PlayerSession
 * nested class. The PlayerSession nested has not been static
 * since it needs to know the state of its enclosing class.
 * 
 * @author Dimitris
 *
 */
public abstract class Player implements Interactor{

	public PlayerType playerType;
	private Map<Integer, Session> playerSessions = new TreeMap<Integer,Session>();
	
	public abstract Event decideCurrentHandEvent() throws RockPaperScissorsException;
	protected abstract void addPlayerTypeNature();
	
	public void newPlayerSession(int sessionRound, Event sessionPlayerEvent, Outcome sessionPlayerOutcome){
		playerSessions.put(sessionRound, new PlayerSession(sessionRound, sessionPlayerEvent, sessionPlayerOutcome));
	}
	
	 public class PlayerSession implements Session{
		private int sessionRound;
		private Event sessionPlayerEvent;
		private Outcome sessionPlayerOutcome;
		
		public PlayerSession(int sessionRound, Event sessionPlayerEvent, Outcome sessionPlayerOutcome){
			this.sessionRound = sessionRound;
			this.sessionPlayerEvent = sessionPlayerEvent;
			this.sessionPlayerOutcome = sessionPlayerOutcome;
		}
		
		@Override
		public PlayerType getPlayerType(){
			return playerType;
		}
		
		@Override
		public int getSessionRound(){
			return sessionRound;
		}
		
		@Override
		public Event getSessionPlayerEvent(){
			return sessionPlayerEvent;
		}
		
		@Override
		public Outcome getSessionPlayerOutcome(){
			return sessionPlayerOutcome;
		}
	}
	
	public Map<Integer, Session> getPlayerSessions(){
		return this.playerSessions;
	}
	
	public int getTotalGameSessionsScore(){
		int score = 0;
		for(Map.Entry<Integer, Session> entry : playerSessions.entrySet()){
			score += entry.getValue().getSessionPlayerOutcome().getScore();
		}
		return score;
	}
}
