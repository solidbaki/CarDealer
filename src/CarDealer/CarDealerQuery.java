package CarDealer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DataAccess.CarDataAccessor;

public class CarDealerQuery {
	private CarDataAccessor accessor;
	private ArrayList<Car> cars;
	private ArrayList<Sale> sales;

	public CarDealerQuery(CarDataAccessor accessor) {
		this.accessor = accessor;
	}

	// Returns an ArrayList of type Car
	public ArrayList<Car> createArrayListOfCars() {
		accessor = new CarDataAccessor();
		List<List<String>> list = accessor.getArrayListOfCars();
		ArrayList<Car> cars = new ArrayList<Car>();
		Car car;
		// Below loop creates car objects and adds it into
		for (int i = 0; i < list.size(); i++) {
			car = new Car(list.get(i).get(0), list.get(i).get(1), Integer.parseInt(list.get(i).get(2)),
					Integer.parseInt(list.get(i).get(2)));
			cars.add(car);
		}
		return cars;
	}

	// Selling a car from current cars
	public void sellCar(ArrayList<Car> cars) {
		Scanner scanner = new Scanner(System.in);
		int carIndex;
		Buyer buyer = createBuyer();
		Car car = null;
		accessor = new CarDataAccessor();
		accessor.printCars();
		System.out.println("Select a car to sell");
		carIndex = scanner.nextInt() - 1;
		// If car exists, decrease amount when one is sold, also check if car is in
		// stock
		if (carIndex < cars.size() && cars.get(carIndex).getNumberOfCars() > 0) {
			cars.get(carIndex).decreaseNumberOfCarsByOne();
			car = new Car(cars.get(carIndex));
		}
		System.out.println(
				"Enter amount recieved for " + car.getStringBrandName() + " " + car.getModel() + " " + car.getYear());
		int amountRecieved = scanner.nextInt();
		Sale sale = new Sale(buyer, car, amountRecieved);
		sales.add(sale);
		scanner.close();
	}

	// Creates and returns a buyer
	public Buyer createBuyer() {
		String name;
		char gender;
		int age;
		Scanner scanner = new Scanner(System.in);

		// If one of the fields validated wrong, method restarts
		System.out.println("Please enter buyer's name");
		name = scanner.nextLine();
		if (!checkBuyerName(name)) {
			System.out.println("Invalid name");
			createBuyer();
		}

		gender = scanner.next().charAt(0);
		if (!checkBuyerGender(gender)) {
			System.out.println("Invalid gender");
			createBuyer();
		}

		age = scanner.nextInt();
		if (!checkBuyerAge(age)) {
			System.out.println("Invalid age");
			createBuyer();
		}

		scanner.close();
		return new Buyer(name, age, gender);
	}

	// Checks buyers name validity
	public boolean checkBuyerName(String name) {
		if (name.length() <= 30) {
			return true;
		}
		return false;
	}

	// Checks buyers gender validity
	public boolean checkBuyerGender(char gender) {
		if (gender == 'M' || gender == 'F') {
			return true;
		}
		return false;
	}

	// Checks buyers age validity
	public boolean checkBuyerAge(int age) {
		if (age >= 18 && age < 80) {
			return true;
		}
		return false;
	}

	// Iterates over a sale ArrayList and calculates performance information
	public void performanceInformation(ArrayList<Sale> sales) {
		int totalNumberOfCarsSold = 0, totalAmountRecieved = 0, numberOfFemaleBuyers = 0, numberOfMaleBuyers = 0,
				numberOfSeniorBuyers = 0, numberOfAdultBuyers = 0, numberOfYoungBuyers = 0;
		Sale sale;
		for (int i = 0; i < sales.size(); i++) {
			sale = new Sale(sales.get(i));
			totalNumberOfCarsSold++;
			totalAmountRecieved += sale.getAmountRecieved();
			if (sale.getBuyer().getGender() == 'M') {
				numberOfMaleBuyers++;
			} else {
				numberOfFemaleBuyers++;
			}
			int age = sale.getBuyer().getAge();
			if (age > 18 && age <= 30) {
				numberOfYoungBuyers++;
			} else if (age > 30 && age < 60) {
				numberOfAdultBuyers++;
			} else {
				numberOfSeniorBuyers++;
			}
		}
		printPerformanceInformation(totalNumberOfCarsSold, totalAmountRecieved, numberOfFemaleBuyers,
				numberOfMaleBuyers, numberOfSeniorBuyers, numberOfAdultBuyers, numberOfYoungBuyers);
	}

	// Prints out the performance information
	public void printPerformanceInformation(int totalNumberOfCarsSold, int totalAmountRecieved,
			int numberOfFemaleBuyers, int numberOfMaleBuyers, int numberOfSeniorBuyers, int numberOfAdultBuyers,
			int numberOfYoungBuyers) {
		System.out.println("*** Performance Information ***");
		System.out.println("Total number of cars sold " + totalNumberOfCarsSold);
		System.out.println("Total amount recieved " + totalAmountRecieved);
		System.out.println("Number of female buyers " + numberOfFemaleBuyers);
		System.out.println("Number of male buyers " + numberOfMaleBuyers);
		System.out.println("Number of senior buyers " + numberOfSeniorBuyers);
		System.out.println("Number of adult buyers " + numberOfAdultBuyers);
		System.out.println("Number of young buyers " + numberOfYoungBuyers);
	}

	// Save into text file
	public boolean saveCars() {
		List<String> carsData = new ArrayList<String>();
		CarDataAccessor carDataAccessor = new DataAccess.CarDataAccessor();
		for (int i = 0; i < this.cars.size(); i++) {
			carsData.add(cars.get(i).toString());
		}
		try {
			// Cast List type to ArrayList, and write modifications into
			carDataAccessor.writeToCurrentCarFile((ArrayList<String>) carsData);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

}
