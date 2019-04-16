package sk.spring.jdbc;

public class Car {
	final static private String SEPARATOR = ", ";
	
	private int id;
	private String brand;
	private String model;
	private int price;
	
	public Car (int id, String brand, String model, int price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel () {
		return model;
	}
	
	public void setModel (String model) {
		this.model = model;
	}
	
	public int getPrice () {
		return price;
	}
	
	public void setPrice (int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder ("Car ");
		builder.append("ID : " + id + SEPARATOR);
		builder.append("Brand : " + brand + SEPARATOR);
		builder.append("Model : " + model + SEPARATOR);
		builder.append("Price : " + price);
		return builder.toString();
	}
}
