package es.mbg.conference;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import es.mbg.conference.domain.Conference;
import es.mbg.conference.exception.FileParameterException;
import es.mbg.conference.exception.InvalidLineException;

public class ConferenceManagerTest {
	@Test
	public void testConferenceTrackManagementMultipleFullDayEvents() throws IOException {
		testConferenceTrackManagement("/input_normal");
	}

	@Test
	public void testConferenceTrackManagementMultipleDayLessEvents() throws IOException {
		testConferenceTrackManagement("/input_less_events");
	}

	@Test
	public void testConferenceTrackManagementSingleDayEvents() throws IOException {
		testConferenceTrackManagement("/input_single_day_events");
	}
	
	@Test
	public void testConferenceTrackManagementLotEvents() throws IOException {
		testConferenceTrackManagement("/input_lot_events");
	}

	private void testConferenceTrackManagement(String inputFile) throws IOException {
		ConferenceManager conferenceManager = new ConferenceManager();
		Conference conference = conferenceManager
				.conferenceSchecduler(FileUtil.getBufferedReaderForResourceFile(inputFile, this));
		assertTrue(FileUtil.contentEquals(getExpectedOutputFile(inputFile),
				conferenceManager.print(conference.getConferenceTracks()).toString(), this));
	}

	private String getExpectedOutputFile(String inputFile) {
		return inputFile + "_expected";
	}
	
    @Test(expected = FileParameterException.class)
    public void testNotInputFile() {
        ConferenceMain.main(null);
    }
    
    @Test(expected = InvalidLineException.class)
    public void testInvalidLineInputFile() throws IOException {
    	testConferenceTrackManagement("/input_invalid_line_events");
    }
}
