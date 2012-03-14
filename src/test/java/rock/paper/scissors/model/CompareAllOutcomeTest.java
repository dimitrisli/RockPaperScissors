package rock.paper.scissors.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.*;

import static rock.paper.scissors.model.Outcome.*;

@RunWith(Parameterized.class)
public class CompareAllOutcomeTest {

	@Parameters
	public static Collection<?> data(){
		return Arrays.asList(new Object[][]{
				{WIN, LOSE, WIN},
				{LOSE, WIN, WIN},
				{DRAW, DRAW, DRAW}
		});
	}
	
	private Outcome playerAOutcome;
	private Outcome playerBOutcome;
	private Outcome winningOutcome;
	
	public CompareAllOutcomeTest(Outcome playerAOutcome, Outcome playerBOutcome, Outcome winningOutcome){
		this.playerAOutcome = playerAOutcome;
		this.playerBOutcome = playerBOutcome;
		this.winningOutcome = winningOutcome;
	}
	
	@Test
	public void testOppositeOutcomes(){
		assertThat(playerAOutcome.tailoredCompareTo(playerBOutcome), equalTo(winningOutcome));
	}
}
