package es.mbg.conference.business;

import es.mbg.conference.config.TypeEvent;
import es.mbg.conference.domain.Event;
import es.mbg.conference.domain.Slot;

public interface SlotManagerI {

	public void addEventToSlot(Slot mornigSlot, Event event, TypeEvent afternoon);

}
