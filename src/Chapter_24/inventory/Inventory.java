package test.stacks.queues;

/*
 * Develop a program that implements a stack of objects 
 * of class Inventory. The components of class Inventory are: 
 * description (string), price (double), location (integer),
 *  number of items in stock (integer). 
 *  Re-implement this data structure as a queue.
 */

public class Inventory {
	
	private String desc;
	private double price;
	private int location;
	private int noInStock;
	
	
	
	public Inventory(String desc, double price, int location, int noInStock) {
		super();
		this.desc = desc;
		this.price = price;
		this.location = location;
		this.noInStock = noInStock;
	}
	
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the location
	 */
	public int getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	/**
	 * @return the noInStock
	 */
	public int getNoInStock() {
		return noInStock;
	}
	/**
	 * @param noInStock the noInStock to set
	 */
	public void setNoInStock(int noInStock) {
		this.noInStock = noInStock;
	}

	@Override
	public String toString(){
		
		return "Inventory Details: "+ desc + ", " + price + ", " + location + ", " + noInStock;

	}
}
