package es.mbg.conference.tracksmanager;

import java.util.List;

import es.mbg.conference.config.Constants;
import es.mbg.conference.config.TypeEvent;
import es.mbg.conference.domain.Conference;
import es.mbg.conference.domain.Event;
import es.mbg.conference.domain.Track;

public class TracksManager implements TracksManagerI {

	private static TracksManager tracksManager;

	public static TracksManager getInstance() {
		if (tracksManager == null) {
			tracksManager = new TracksManager();
		}
		return tracksManager;
	}

	public void schedulerEventsTracks(Conference conference, List<Event> listEvents, List<Event> listEventLightning) {

		Track track = new Track();
		for (Event event : listEvents) {
			if (track.hasTimeForEvent(event)) {
				if (track.getMornigSlot().hasTimeForEvent(event)) {
					track.getMornigSlot().addEventToSlot(event, TypeEvent.MOORNING);
				} else if (track.getAfternoonSlot().hasTimeForEvent(event)) {
					track.getAfternoonSlot().addEventToSlot(event, TypeEvent.AFTERNOON);
				}
				track.refreshTimeTrack();
			} else {
				track.getAfternoonSlot().addEventToSlot(new Event(Constants.NETWORKING_EVENT, 0), TypeEvent.AFTERNOON);
				conference.getConferenceTracks().add(track);
				track = new Track();
				if (track.getMornigSlot().hasTimeForEvent(event)) {
					track.getMornigSlot().addEventToSlot(event, TypeEvent.MOORNING);
				}
			}

		}
		track.getAfternoonSlot().addEventToSlot(new Event(Constants.NETWORKING_EVENT, 0), TypeEvent.AFTERNOON);
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
