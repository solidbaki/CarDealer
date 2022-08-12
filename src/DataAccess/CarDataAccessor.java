package DataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarDataAccessor {
	// Prints current file data
	// Will be used in menu to show current car data
	public void printCars() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(
					new FileReader("C:\\Users\\berke\\eclipse-workspace\\CarDealer\\car2022-07-21.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// Reads car data text file line by line and returns a list of cars
	// Will be used to retrieve data in several places
	public List<List<String>> getArrayListOfCars() {
		List<List<String>> cars = new ArrayList<List<String>>();
		BufferedReader reader = null;
		StringTokenizer stringTokenizer = null;
		try {
			reader = new BufferedReader(
					new FileReader("C:\\Users\\berke\\eclipse-workspace\\CarDealer\\car2022-07-21.txt"));
			String line = reader.readLine();
			// Below loop reads lines and creates a list of cars separating by delimiters
			while (line != null) {
				List<String> carLine = new ArrayList<String>();
				stringTokenizer = new StringTokenizer(line, ",");
				while (stringTokenizer.hasMoreTokens()) {
					carLine.add(stringTokenizer.nextToken());
				}
				cars.add(carLine);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return cars;
	}

	// Expects a 2D ArrayList and saves it into the text file
	// Will be used when user checkout and display daily sells
	// Returns a boolean if method performed successfully
	public boolean writeToCarFile(List<List<String>> cars) throws IOException {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter("C:\\Users\\berke\\eclipse-workspace\\CarDealer\\car2022-07-21.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			// The loop below writes each line of ArrayList into text file 
			// by joining inner ArrayLists with delimiter ","
			for (int i = 0; i < cars.size(); i++) {
				String line = String.join(",", cars.get(i));
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			bufferedWriter.write("Pagani,Zonda,2022,15");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			bufferedWriter.close();
			fileWriter.close();
		}
		return true;
	}
	
	// Takes an ArrayList of strings which holds car data after sales are performed
	// Modifies the currentCarFile.txt
	public boolean writeToCurrentCarFile(ArrayList<String> carData) throws IOException {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter("C:\\Users\\berke\\eclipse-workspace\\CarDealer\\currentCarFile.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			// The loop below writes each line of ArrayList into text file 
			// by joining inner ArrayLists with delimiter ","
			for (int i = 0; i < carData.size(); i++) {
				bufferedWriter.write(carData.get(i));
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			bufferedWriter.close();
			fileWriter.close();
		}
		return true;
	}
}
