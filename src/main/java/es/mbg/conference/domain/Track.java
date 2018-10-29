package es.mbg.conference.domain;

import java.time.LocalTime;

import es.mbg.conference.config.Constants;

public class Track {

	private Slot mornigSlot;
	private Slot lunchSlot;
	private Slot afternoonSlot;
	private int maxTimeTrack;

	public Track() {
		this.mornigSlot = new Slot(Constants.TIME_MORNING_SLOT);
		this.afternoonSlot = new Slot(Constants.TIME_MAX_AFTERNOON_SLOT);
		this.lunchSlot = new Slot(Constants.TIME_LUNCH_SLOT);
		addLunchSlot();
		this.maxTimeTrack = mornigSlot.getTimeMinutes() + afternoonSlot.getTimeMinutes();
	}

	private void addLunchSlot() {
		Event lunchEvent = new Event(Constants.LUNCH, Constants.TIME_LUNCH_SLOT);
		LocalTime startTime = LocalTime.NOON;
		lunchEvent.setStartTime(startTime);
		lunchSlot.getListEvent().add(lunchEvent);
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
