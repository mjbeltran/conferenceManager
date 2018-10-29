package es.mbg.conference.domain;

import java.util.ArrayList;
import java.util.List;

import es.mbg.conference.config.Constants;

public class Slot {

	private int timeMinutes;
	private List<Event> listEvent;

	public Slot(int minutes) {
		this.timeMinutes = minutes;
		this.listEvent = new ArrayList<Event>();
	}

	public void substractTime(int minutes) {
		this.timeMinutes = this.timeMinutes - minutes;
	}

	public int getTimeMinutes() {
		return timeMinutes;
	}

	public void setTimeMinutes(int timeMinutes) {
		this.timeMinutes = timeMinutes;
	}

	public List<Event> getListEvent() {
		return listEvent;
	}

	public void setListEvent(List<Event> listEvent) {
		this.listEvent = listEvent;
	}

	public boolean hasTimeForEvent(Event event) {
		return this.timeMinutes >= event.getDurationMinutes();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Event event : listEvent) {
			if (event.getTitle().contains(Constants.LIGHTNING)) {
				str.append(event.toString().replace("5min", "")).append(Constants.NEW_LINE);
			} else if (event.getTitle().contains(Constants.LUNCH)) {
				str.append(event.toString().replace("60min", "")).append(Constants.NEW_LINE);
			} else if (event.getTitle().contains(Constants.NETWORKING_EVENT)) {
				str.append(event.toString().replace("0min", "")).append(Constants.NEW_LINE);
			} else {
				str.append(event.toString()).append(Constants.NEW_LINE);
			}
		}
		return str.toString();
	}

}
