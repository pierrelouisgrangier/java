package fr.keyce.openit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ComputersReaderWriter {
	private final static String FILE_PATH = "./computers.csv";

	public List<Computer> read() {
		List<Computer> computers = null;
		try {
			List<String> allLines = Files.readAllLines(Paths.get(FILE_PATH));
			List<Computer> computersTmp = new ArrayList<Computer>(allLines.size());
			allLines.forEach(line -> computersTmp.add(Computer.transformCsvToComputer(line)));
			computers = computersTmp;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return computers;
	}

	public void write(List<Computer> computers) {

		List<String> lines = new ArrayList<String>();
		computers.forEach(computer -> lines.add(computer.toCSV()));

		try {
			Files.write(Paths.get(FILE_PATH), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
