package rock.paper.scissors.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.*;

import static rock.paper.scissors.model.Event.*;
import static rock.paper.scissors.model.Outcome.*;

@RunWith(Parameterized.class)
public class CompareAllEventsTest {

	@Parameters
	public static Collection<?> data(){
		return Arrays.asList(new Object[][]{
				{FIST, FIST, DRAW},
				{FIST, OPEN_HAND, LOSE},
				{FIST, TWO_FINGERS, WIN},
				
				{OPEN_HAND, OPEN_HAND, DRAW},
				{OPEN_HAND, FIST, WIN},
				{OPEN_HAND, TWO_FINGERS, LOSE},
				
				{TWO_FINGERS, TWO_FINGERS, DRAW},
				{TWO_FINGERS, FIST, LOSE},
				{TWO_FINGERS, OPEN_HAND, WIN}
		});
	}
	
	private Event playerAHand;
	private Event playerBHand;
	private Outcome outcome;
	
	public CompareAllEventsTest(Event playerAHand, Event playerBHand, Outcome outcome){
		this.playerAHand = playerAHand;
		this.playerBHand = playerBHand;
		this.outcome = outcome;
	}
	
	@Test
	public void testRockDrawsRockAllEventsOutcomes() {
		assertThat(playerAHand.tailoredCompareTo(playerBHand), equalTo(outcome));
	}

}
