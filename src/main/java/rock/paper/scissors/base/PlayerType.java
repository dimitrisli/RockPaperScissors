package rock.paper.scissors.base;

/**
 * Useful enum to decide according output in the view.
 * 
 * @author Dimitris
 *
 */
public enum PlayerType {

	HUMAN("Human"), COMPUTER("Computer");
	
	private String playerType;
	private PlayerType(String playerType){
		this.playerType = playerType;
	}
	@Override
	public String toString() {
		return playerType;
	}
}
