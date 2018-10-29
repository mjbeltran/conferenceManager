package es.mbg.conference.business;

import java.util.List;

import es.mbg.conference.domain.Conference;
import es.mbg.conference.domain.Event;
import es.mbg.conference.domain.Track;

public interface TracksManagerI {

	void schedulerEventsTracks(Conference conference, List<Event> listEvents, List<Event> listEventLightning);

	String printTracks(List<Track> conferenceTracks);
}
