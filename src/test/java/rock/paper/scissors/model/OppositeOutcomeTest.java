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
public class OppositeOutcomeTest {

	@Parameters
	public static Collection<?> data(){
		return Arrays.asList(new Object[][]{
				{WIN, LOSE},
				{LOSE, WIN},
				{DRAW, DRAW}
		});
	}
	
	private Outcome outcome;
	private Outcome oppositeOutcome;
	
	public OppositeOutcomeTest(Outcome outcome, Outcome oppositeOutcome){
		this.outcome = outcome;
		this.oppositeOutcome = oppositeOutcome;
	}
	
	@Test
	public void testOppositeOutcomes(){
		assertThat(outcome.oppositOutcome(), equalTo(oppositeOutcome));
	}
}
