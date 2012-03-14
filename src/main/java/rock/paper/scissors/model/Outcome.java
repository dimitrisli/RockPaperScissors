package rock.paper.scissors.model;

import rock.paper.scissors.base.TailoredComparable;

/**
 * The outcome of a particular session. A score is attached
 * to every outcome to quickly calculate the winner in every
 * session and/or in the end of the game.
 * 
 * @author Dimitris
 *
 */
public enum Outcome implements TailoredComparable<Outcome, Outcome>{

	WIN(2){
		public Outcome tailoredCompareTo(Outcome opponentOutcome){
			Outcome outcome=null;
			switch(opponentOutcome){
			case LOSE:
				outcome = WIN;
			}
			return outcome;
		}
		
		public Outcome oppositOutcome(){
			return LOSE;
		}
	}, 
	LOSE(0){
		public Outcome tailoredCompareTo(Outcome opponentOutcome){
			Outcome outcome=null;
			switch(opponentOutcome){
			case WIN:
				outcome = WIN;
			}
			return outcome;
		}
		
		public Outcome oppositOutcome(){
			return WIN;
		}
	}, 
	DRAW(1){
		public Outcome tailoredCompareTo(Outcome opponentOutcome){
			Outcome outcome=null;
			switch(opponentOutcome){
			case DRAW:
				outcome = DRAW;
			}
			return outcome;
		}
		
		public Outcome oppositOutcome(){
			return DRAW;
		}
	};
	
	public abstract Outcome oppositOutcome();
	public abstract Outcome tailoredCompareTo(Outcome opponentOutcome);
	
	private int outcomeScore;
	private Outcome(int score){
		this.outcomeScore = score;
	}
	public int getScore(){
		return this.outcomeScore;
	}
}