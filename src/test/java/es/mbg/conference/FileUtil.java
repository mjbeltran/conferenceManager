package es.mbg.conference;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import es.mbg.conference.config.Constants;

public class FileUtil {
	private FileUtil() {
	}

	public static List<String> getBufferedReaderForResourceFile(String resourceFile, Object context) {
		URL url = context.getClass().getResource(resourceFile);
		String path = null;

		List<String> linesFile = new ArrayList<String>();
		try {
			path = loadResourceByUrl(url);
			List<List<String>> values = Files.lines(Paths.get(path)).map(line -> Arrays.asList(line.split(",")))
					.collect(Collectors.toList());
			values.forEach(value -> linesFile.add(value.toString().replace("[", "").replace("]", "")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return linesFile;

	}

	private static String loadResourceByUrl(URL u) throws IOException {
		String path = null;
		if (u != null) {
			path = u.getPath();
			path = path.replaceFirst("^/(.:/)", "$1");
		}
		return path;
	}

	public static boolean contentEquals(String resourceFile, String string, Object context) throws IOException {
		List<String> listEvents = getBufferedReaderForResourceFile(resourceFile, context);

		StringBuilder strb = new StringBuilder();
		for (String event : listEvents) {
			strb.append(event).append(Constants.NEW_LINE);
		}
		return strb.toString().equals(string);
	}
}
