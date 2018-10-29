package es.mbg.conference.business.impl;

import java.util.regex.Matcher;

import es.mbg.conference.business.EventManagerI;
import es.mbg.conference.config.Constants;
import es.mbg.conference.domain.Event;
import es.mbg.conference.exception.InvalidLineException;

public class EventManager implements EventManagerI {

	private static EventManager eventManager;

	public static EventManager getInstance() {
		if (eventManager == null) {
			eventManager = new EventManager();
		}
		return eventManager;
	}

	@Override
	public Event treatmentEventLigne(String line) {
		if (line.length() == 0) {
			return null;
		}

		Matcher match = Constants.INPUT_LINE_PATTERN.matcher(line);
		if (match.find() == false) {
			throw new InvalidLineException("Invalid input line: " + line);
		}

		String title = line.substring(0, line.lastIndexOf(Constants.EVENT_STRING_SEPARATOR));
		String minutesString = line.substring(line.lastIndexOf(Constants.EVENT_STRING_SEPARATOR) + 1);
		String minutes = minutesString.replaceAll(Constants.STR_MIN, "");
		int intMinutes;
		if (Constants.LIGHTNING.equals(minutesString)) {
			intMinutes = Constants.DURATION_LIGHTNING_EVENT;
			title = title + Constants.EVENT_STRING_SEPARATOR + Constants.LIGHTNING;
		} else {
			intMinutes = Integer.parseInt(minutes);
		}
		Event event = new Event(title, intMinutes);

		return event;
	}
}
