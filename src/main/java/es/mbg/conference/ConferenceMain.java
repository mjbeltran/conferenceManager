package es.mbg.conference;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import es.mbg.conference.domain.Conference;
import es.mbg.conference.exception.FileParameterException;

/**
 * 
 * @author mjbeltran
 *
 */
public class ConferenceMain {
	public static void main(String[] args) {
		if (args == null || args.length < 1) {
			throw new FileParameterException("Input file is necessary to execute this programme");
		}

		String inputFile = args[0].toString();

		List<String> linesFile = new ArrayList<String>();
		try (Stream<String> lines = Files.lines(Paths.get(inputFile))) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			values.forEach(value -> linesFile.add(value.toString().replace("[", "").replace("]", "")));
			ConferenceManager conferenceManager = new ConferenceManager();
			Conference conference = conferenceManager.conferenceSchecduler(linesFile);
			String conferencesStr = conferenceManager.print(conference.getConferenceTracks());
			System.out.println(conferencesStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
