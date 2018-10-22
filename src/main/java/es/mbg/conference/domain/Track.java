package es.mbg.conference.domain;

import es.mbg.conference.config.Constants;
import es.mbg.conference.config.TypeEvent;

public class Track {

	private Slot mornigSlot;
	private Slot lunchSlot;
	private Slot afternoonSlot;
	private int maxTimeTrack;

	public Track() {
		this.mornigSlot = new Slot(Constants.TIME_MORNING_SLOT);
		this.afternoonSlot = new Slot(Constants.TIME_MAX_AFTERNOON_SLOT);
		this.lunchSlot = new Slot(Constants.TIME_LUNCH_SLOT);
		Event lunchEvent = new Event(Constants.LUNCH, Constants.TIME_LUNCH_SLOT);
		lunchSlot.addEventToSlot(lunchEvent,TypeEvent.LUNCH);
		this.maxTimeTrack = mornigSlot.getTimeMinutes() + afternoonSlot.getTimeMinutes();
	}

	public Slot getMornigSlot() {
		return mornigSlot;
	}

	public void setMornigSlot(Slot mornigSlot) {
		this.mornigSlot = mornigSlot;
	}

	public Slot getLunchSlot() {
		return lunchSlot;
	}

	public void setLunchSlot(Slot lunchSlot) {
		this.lunchSlot = lunchSlot;
	}

	public Slot getAfternoonSlot() {
		return afternoonSlot;
	}

	public void setAfternoonSlot(Slot afternoonSlot) {
		this.afternoonSlot = afternoonSlot;
	}

	public int getMaxTimeTrack() {
		return maxTimeTrack;
	}

	public void setMaxTimeTrack(int maxTimeTrack) {
		this.maxTimeTrack = maxTimeTrack;
	}

	public void refreshTimeTrack() {
		this.maxTimeTrack = mornigSlot.getTimeMinutes() + afternoonSlot.getTimeMinutes();
	}
	
	public boolean hasTimeForEvent(Event event) {
		return this.maxTimeTrack >= event.getDurationMinutes();
	}

}
