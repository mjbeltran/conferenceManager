package es.mbg.conference.domain;

import java.time.LocalTime;

import es.mbg.conference.config.Constants;
import es.mbg.conference.utils.Utils;

public class Event implements Comparable<Event> {

	private String title;
	private int durationMinutes;
	private LocalTime startTime;

	public Event(String title, int durationMinutes) {
		this.title = title;
		this.durationMinutes = durationMinutes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public int compareTo(Event o) {
		return o.getDurationMinutes() - getDurationMinutes();
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append(Utils.timeFormat12h(startTime)).append(Constants.EVENT_STRING_SEPARATOR).append(title)
				.append(Constants.EVENT_STRING_SEPARATOR).append(durationMinutes).append(Constants.STR_MIN);
		return strb.toString();
	}

}
