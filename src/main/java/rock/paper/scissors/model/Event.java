package rock.paper.scissors.model;

import rock.paper.scissors.base.TailoredComparable;
import static rock.paper.scissors.model.Outcome.*;

/**
 * It has been decided to capture
 * all possible events in this enum. Both name and gestures
 * are captured. The are also comparable and provide convenience
 * methods to retrieve events based on name or gesture.
 * 
 * @author Dimitris
 *
 */

public enum Event implements TailoredComparable<Event, Outcome> {

	FIST("Rock", "Fist") {
		@Override
		public Outcome tailoredCompareTo(Event oponentEvent) {
			Outcome outcome = null;
			switch (oponentEvent) {
			case FIST:
				outcome = DRAW;
				break;
			case OPEN_HAND:
				outcome = LOSE;
				break;
			case TWO_FINGERS:
				outcome = WIN;
				break;
			}
			return outcome;
		}
	},
	OPEN_HAND("Paper", "Open_Hand") {
		@Override
		public Outcome tailoredCompareTo(Event oponentEvent) {
			Outcome outcome = null;
			switch (oponentEvent) {
			case FIST:
				outcome = WIN;
				break;
			case OPEN_HAND:
				outcome = DRAW;
				break;
			case TWO_FINGERS:
				outcome = LOSE;
				break;
			}
			return outcome;
		}
	},
	TWO_FINGERS("Scissors", "Two_Fingers") {
		@Override
		public Outcome tailoredCompareTo(Event oponentEvent) {
			Outcome outcome = null;
			switch (oponentEvent) {
			case FIST:
				outcome = LOSE;
				break;
			case OPEN_HAND:
				outcome = WIN;
				break;
			case TWO_FINGERS:
				outcome = DRAW;
				break;
			}
			return outcome;
		}
	};

	abstract public Outcome tailoredCompareTo(Event opponentEvent);

	private Event(String name, String gesture) {
		this.name = name;
		this.gesture = gesture;
	}

	private String name;
	private String gesture;

	public String getName() {
		return name;
	}

	public String getGesture() {
		return gesture;
	}

	public static Event getEventByName(String name) {
		Event outcomeEvent = null;
		for (Event event : values()) {
			if (name.equalsIgnoreCase(event.getName())) {
				outcomeEvent = event;
			}
		}
		return outcomeEvent;
	}

	public static Event getEventByGesture(String gesture) {
		Event outcomeEvent = null;
		for (Event event : values()) {
			if (gesture.equalsIgnoreCase(event.getGesture())) {
				outcomeEvent = event;
			}
		}
		return outcomeEvent;
	}

	public static Event getEventByNameOrGesture(String nameOrGesture) {
		Event event = getEventByName(nameOrGesture);
		if (event == null) {
			event = getEventByGesture(nameOrGesture);
		}
		return event;
	}
}
