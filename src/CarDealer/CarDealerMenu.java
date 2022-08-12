package CarDealer;

import java.util.Scanner;
import DataAccess.CarDataAccessor;

public class CarDealerMenu {
	public void start() {
		Scanner scanner = null;
		CarDataAccessor carDataAccessor = new CarDataAccessor();
		CarDealerQuery carDealerQuery = new CarDealerQuery(carDataAccessor);
		try {
			scanner = new Scanner(System.in);
			int choice;
			while (true) {
				printMenu();
				if (scanner.hasNextLine() && Integer.parseInt(scanner.nextLine()) > 0
						&& Integer.parseInt(scanner.nextLine()) < 5) {
					choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						System.out.println("Last saved car data");
						carDataAccessor.printCars();
						break;
					case 2:
						System.out.println("Sell");
						carDealerQuery.sellCar(carDealerQuery.createArrayListOfCars());
						break;
					case 3:
						System.out.println("Save");
						carDealerQuery.saveCars();
						break;
					case 4:
						System.out.println("Program terminating");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input");
						scanner.next();
					}
				} else if (!scanner.hasNextInt() || scanner.nextInt() < 0 || scanner.nextInt() > 5) {
					System.out.println("Please enter a valid input\n");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private void printMenu() {
		System.out.println("Press 1 to show car data");
		System.out.println("Press 2 to sell cars");
		System.out.println("Press 3 to save data");
		System.out.println("Press 4 to exit");
	}
}
