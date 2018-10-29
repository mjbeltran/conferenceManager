package es.mbg.conference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.mbg.conference.business.EventManagerI;
import es.mbg.conference.business.TracksManagerI;
import es.mbg.conference.business.impl.EventManager;
import es.mbg.conference.business.impl.TracksManager;
import es.mbg.conference.domain.Conference;
import es.mbg.conference.domain.Event;
import es.mbg.conference.domain.Track;

/**
 * 
 * @author mjbeltran
 *
 */
public class ConferenceManager {

	private TracksManagerI tracksManager = TracksManager.getInstance();
	
	private EventManagerI eventManager = EventManager.getInstance();
	

	public Conference conferenceSchecduler(List<String> linesFile) {

		Conference conference = new Conference();
		List<Event> listEvents = new ArrayList<Event>();
		List<Event> listEventLightning = new ArrayList<Event>();

		Event evento;
		for (String line : linesFile) {
			evento = eventManager.treatmentEventLigne(line);
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
