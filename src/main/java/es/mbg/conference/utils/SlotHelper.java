package es.mbg.conference.utils;

import java.time.LocalTime;
import java.util.List;

import es.mbg.conference.config.Constants;
import es.mbg.conference.domain.Event;

public class SlotHelper {

	public static void addMoorningEvent(List<Event> listEvent, Event event) {
		Event eventAux;
		if (listEvent.isEmpty()) {
			LocalTime startTime = LocalTime.MIN;
			startTime = startTime.plusHours(Constants.INIT_CONFERENCE_HOUR);
			event.setStartTime(startTime);
		} else {
			eventAux = listEvent.get(listEvent.size() - 1);
			LocalTime startTime = eventAux.getStartTime().plusMinutes(eventAux.getDurationMinutes());
			event.setStartTime(startTime);
		}

	}

	public static void addAfternoonEvent(List<Event> listEvent, Event event) {
		Event eventAux;
		if (listEvent.isEmpty() && event.getTitle().equals(Constants.NETWORKING_EVENT)) {
			LocalTime startTime = LocalTime.NOON.plusHours(Constants.PLUS_HOURS_AFTER_NOON);
			event.setStartTime(startTime);
		} else if (listEvent.isEmpty()) {
			LocalTime startTime = LocalTime.NOON;
			startTime = startTime.plusHours(Constants.PLUS_HOURS_AFTER_LUNCH);
			event.setStartTime(startTime);
		} else {
			if (!event.getTitle().equals(Constants.NETWORKING_EVENT)) {
				eventAux = listEvent.get(listEvent.size() - 1);
				LocalTime startTime = eventAux.getStartTime().plusMinutes(eventAux.getDurationMinutes());
				event.setStartTime(startTime);
			} else {
				eventAux = listEvent.get(listEvent.size() - 1);
				LocalTime startTime = eventAux.getStartTime().plusMinutes(eventAux.getDurationMinutes());
				if (startTime.getHour() < Constants.MIN_NETWORKING_TIME) {
					startTime = LocalTime.NOON.plusHours(Constants.PLUS_HOURS_AFTER_NOON);
				}
				event.setStartTime(startTime);
			}
		}

	}

}
