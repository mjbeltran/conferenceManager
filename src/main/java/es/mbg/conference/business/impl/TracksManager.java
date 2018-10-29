package es.mbg.conference.business.impl;

import java.util.List;

import es.mbg.conference.business.SlotManagerI;
import es.mbg.conference.business.TracksManagerI;
import es.mbg.conference.config.Constants;
import es.mbg.conference.config.TypeEvent;
import es.mbg.conference.domain.Conference;
import es.mbg.conference.domain.Event;
import es.mbg.conference.domain.Track;

public class TracksManager implements TracksManagerI {

	private static TracksManager tracksManager;

	private static SlotManagerI slotManager;

	public static TracksManager getInstance() {
		if (tracksManager == null) {
			tracksManager = new TracksManager();
		}
		return tracksManager;
	}

	public void schedulerEventsTracks(Conference conference, List<Event> listEvents, List<Event> listEventLightning) {

		Track track = new Track();
		slotManager = new SlotManager();
		for (Event event : listEvents) {
			if (track.hasTimeForEvent(event)) {
				if (track.getMornigSlot().hasTimeForEvent(event)) {
					slotManager.addEventToSlot(track.getMornigSlot(), event, TypeEvent.MOORNING);
				} else if (track.getAfternoonSlot().hasTimeForEvent(event)) {
					slotManager.addEventToSlot(track.getAfternoonSlot(), event, TypeEvent.AFTERNOON);
				}
				track.refreshTimeTrack();
			} else {
				slotManager.addEventToSlot(track.getAfternoonSlot(), new Event(Constants.NETWORKING_EVENT, 0),
						TypeEvent.AFTERNOON);
				conference.getConferenceTracks().add(track);
				track = new Track();
				if (track.getMornigSlot().hasTimeForEvent(event)) {
					slotManager.addEventToSlot(track.getMornigSlot(), event, TypeEvent.MOORNING);
				}
			}

		}
		slotManager.addEventToSlot(track.getAfternoonSlot(), new Event(Constants.NETWORKING_EVENT, 0),
				TypeEvent.AFTERNOON);
		conference.getConferenceTracks().add(track);
	}

	public String printTracks(List<Track> conferenceTracks) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < conferenceTracks.size(); i++) {
			if (i > 0) {
				str.append(Constants.NEW_LINE);
			}
			str.append("Track " + (i + 1) + Constants.TRACK_SEPARATOR + Constants.NEW_LINE);
			str.append(conferenceTracks.get(i).getMornigSlot().toString());
			str.append(conferenceTracks.get(i).getLunchSlot().toString());
			str.append(conferenceTracks.get(i).getAfternoonSlot().toString());
		}
		return str.toString();
	}
}
