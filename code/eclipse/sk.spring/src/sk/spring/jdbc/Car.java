package sk.spring.jdbc;

import java.util.Arrays;

public class Car {
	final static private String SEPARATOR = "; ";
	
	private int id;
	private String brand;
	private String model;
	private int price;
	private String description;
	private byte[] image;
	
	public Car (int id, String brand, String model, int price, String description, byte[] image) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.description = description;
		this.image = image;
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
	
	public String getDescription () {
		return description;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	public byte[] getImage () {
		return image;
	}
	
	public void setImage (byte[] image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder ("Car ");
		builder.append("ID : " + id + SEPARATOR);
		builder.append("Brand : " + brand + SEPARATOR);
		builder.append("Model : " + model + SEPARATOR);
		builder.append("Price : " + price + SEPARATOR);
		builder.append("Description : " + description + SEPARATOR);
		builder.append("Image Binary :" + Arrays.toString(image));
		return builder.toString();
	}
}
