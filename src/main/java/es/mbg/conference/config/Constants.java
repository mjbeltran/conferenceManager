package es.mbg.conference.config;

import java.util.regex.Pattern;

public class Constants {

	public static final Pattern INPUT_LINE_PATTERN = Pattern.compile("^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");
	public static final int TIME_MORNING_SLOT = 180;
	public static final int TIME_MAX_AFTERNOON_SLOT = 240;
	public static final int TIME_MIN_AFTERNOON_SLOT = 180;
	public static final int TIME_LUNCH_SLOT = 60;
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String TRACK_SEPARATOR = ":";
	public static final String EVENT_STRING_SEPARATOR = " ";
	public static final long INIT_CONFERENCE_HOUR = 9;
	public static final String LIGHTNING = "lightning";
	public static final String LUNCH = "LUNCH";
	public static final String NETWORKING_EVENT = "Networking Event";
	public static final String STR_MIN = "min";
	public static long LUNCH_TIME = 12;
	public static long MIN_NETWORKING_TIME = 16;
	public static int DURATION_LIGHTNING_EVENT = 5;
	public static int PLUS_HOURS_AFTER_NOON = 4;
	public static int PLUS_HOURS_AFTER_LUNCH = 1;
	
	

}
