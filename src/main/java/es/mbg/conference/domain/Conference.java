package es.mbg.conference.domain;

import java.util.ArrayList;
import java.util.List;

public class Conference {

	private List<Track> conferenceTracks;

	public Conference() {
		this.setConferenceTracks(new ArrayList<Track>());
	}

	public List<Track> getConferenceTracks() {
		return conferenceTracks;
	}

	public void setConferenceTracks(List<Track> conferenceTrack) {
		this.conferenceTracks = conferenceTrack;
	}

}
