package es.mbg.conference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.mbg.conference.domain.Conference;
import es.mbg.conference.domain.Event;
import es.mbg.conference.domain.Track;
import es.mbg.conference.tracksmanager.TracksManager;
import es.mbg.conference.tracksmanager.TracksManagerI;
import es.mbg.conference.utils.EventHelper;

/**
 * 
 * @author mjbeltran
 *
 */
public class ConferenceManager {

	private TracksManagerI tracksManager = TracksManager.getInstance();

	public Conference conferenceSchecduler(List<String> linesFile) {

		Conference conference = new Conference();
		List<Event> listEvents = new ArrayList<Event>();
		List<Event> listEventLightning = new ArrayList<Event>();

		Event evento;
		for (String line : linesFile) {
			evento = EventHelper.treatmentEventLigne(line);
			listEvents.add(evento);
		}

		Collections.sort(listEvents);
		tracksManager.schedulerEventsTracks(conference, listEvents, listEventLightning);

		return conference;
	}

	public String print(List<Track> conferenceTracks) {
		return tracksManager.printTracks(conferenceTracks);
	}

}
