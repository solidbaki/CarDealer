package CarDealer;

public class Buyer {
	private String name;
	private int age;
	private char gender;
	
	public Buyer(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public Buyer(Buyer buyer) {
		super();
		this.name = buyer.name;
		this.age = buyer.age;
		this.gender = buyer.gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Buyer " + this.name + " is " + this.age + " years old.(" + this.age +") ";
	}
}
