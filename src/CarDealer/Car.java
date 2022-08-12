package CarDealer;

public class Car {
	private String stringBrandName;
	private String model;
	private int year;
	private int numberOfCars;

	public Car(String stringBrandName, String model, int year, int numberOfCars) {
		super();
		this.stringBrandName = stringBrandName;
		this.model = model;
		this.year = year;
		this.numberOfCars = numberOfCars;
	}

	public Car(Car car) {
		this.stringBrandName = car.stringBrandName;
		this.model = car.model;
		this.year = car.year;
		this.numberOfCars = car.numberOfCars;
	}

	@Override
	public String toString() {
		return this.stringBrandName + "," + this.model + "," + this.year + "," + this.numberOfCars;
	}

	// Method will be used when a car is sold
	public void decreaseNumberOfCarsByOne() {
		numberOfCars -= 1;
	}

	public String getStringBrandName() {
		return stringBrandName;
	}

	public void setStringBrandName(String stringBrandName) {
		this.stringBrandName = stringBrandName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(int numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
}
