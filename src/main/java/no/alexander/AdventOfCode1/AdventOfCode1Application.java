package no.alexander.AdventOfCode1;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventOfCode1Application implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(AdventOfCode1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(AdventOfCode1Application.class, args);
	}

	@Override
	public void run(String... args) throws URISyntaxException, IOException {
		LOG.info("Hello world!");
		
		URL input = getClass().getClassLoader().getResource("input.txt");
		File file = new File(input.toURI());
		
		List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		partOne(lines);
		partTwo(lines);
	}
	
	public void partOne(List<String> lines) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = i; j < lines.size(); j++) {
				var iVal = Integer.valueOf(lines.get(i));
				var jVal = Integer.valueOf(lines.get(j));
				if ( iVal + jVal == 2020) {
					LOG.info("i=" + iVal + " j=" + jVal + ", i*j=" + (iVal * jVal ));
				}
			}
		}
	}
	
	public void partTwo(List<String> lines) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = i; j < lines.size(); j++) {
				for (int k = j; k < lines.size(); k++) {
					var iVal = Integer.valueOf(lines.get(i));
					var jVal = Integer.valueOf(lines.get(j));
					var kVal = Integer.valueOf(lines.get(k));
					if ( iVal + jVal + kVal == 2020) {
						LOG.info("result=" + (iVal * jVal * kVal));
					}	
				}
			}
		}
	}
}
