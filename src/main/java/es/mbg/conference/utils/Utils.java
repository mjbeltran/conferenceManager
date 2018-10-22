package es.mbg.conference.utils;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Utils {

	/**
	 * Convert TemporalAccessor to string format AM/PM
	 *
	 * @param tmpAccessor
	 * @return String
	 */
	public static String timeFormat12h(TemporalAccessor tmpAccessor) {
		return DateTimeFormatter.ofPattern("hh:mma").format(tmpAccessor);
	}
}
