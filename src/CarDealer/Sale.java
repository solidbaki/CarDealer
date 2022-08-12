package CarDealer;

public class Sale {
	private Buyer buyer;
	private Car car;
	private int amountRecieved;
	
	public Sale(Buyer buyer, Car car, int amountRecieved) {
		this.buyer = buyer;
		this.car = car;
		this.amountRecieved = amountRecieved;
	}

	public Sale(Sale sale) {
		this.buyer = sale.buyer;
		this.car = sale.car;
		this.amountRecieved = sale.amountRecieved;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getAmountRecieved() {
		return amountRecieved;
	}

	public void setAmountRecieved(int amountRecieved) {
		this.amountRecieved = amountRecieved;
	}
	
}
