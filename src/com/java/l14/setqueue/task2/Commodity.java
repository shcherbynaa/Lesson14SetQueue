package com.java.l14.setqueue.task2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Commodity {

	String name;
	private double length;
	private double width;
	private double height;
	public static Scanner sc = new Scanner(System.in);


	public Commodity(String name, double length, double width, double height) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", length=" + length + ", width=" + width + ", height=" + height + "]";
	}

	public static void addGoods(TreeSet<Commodity> set, String name, double length, double width, double height) {
		set.add(new Commodity(name, length, width, height));
	}

	public static void removeGoods(TreeSet<Commodity> set, String name) {
		Iterator<Commodity> iterator =  set.iterator();
		while(iterator.hasNext()) {
			Commodity next  = (Commodity) iterator.next();
			if(iterator.next().getName() == name) {
				iterator.remove();
			}
		}
	}

	public static void replaceGoods(TreeSet<Commodity> set, String nameToReplace, String name, double length, double width, double height) {
		Iterator<Commodity> iterator =  set.iterator();
		while(iterator.hasNext()) {
			Commodity next  = (Commodity) iterator.next();
			if(iterator.next().getName() == nameToReplace) {
				iterator.next().setName(name);
				iterator.next().setLength(length);
				iterator.next().setWidth(width);
				iterator.next().setHeight(height);

			}
		}
	}

	public static void sortByName(TreeSet<Commodity> set) {
		TreeSet set1 = new TreeSet<Commodity>(new ComparatorCommodityByName()); //???? як посортувати сет, 
		//не створюючи новий сет, щоб не викликати компаратор в конструкторі
		set1.addAll(set);
	}

	public static void sortByLength(TreeSet<Commodity> set) {

	}

	public static void sortByWidth(TreeSet<Commodity> set) {

	}

	public static void sortByHeight(TreeSet<Commodity> set) {

	}

	public static void printElement(int index) {

	}

	public static int menu() {

		System.out.println("Enter a number to make your choice:");
		System.out.println("1. Add goods");
		System.out.println("2. Remove goods");
		System.out.println("3. Replace goods");
		System.out.println("4. Sort goods by name");
		System.out.println("5. Sort goods by length");
		System.out.println("6. Sort goods by width");
		System.out.println("7. Sort goods by height");
		System.out.println("8. Print element i");
		System.out.println("9. Exit");
		System.out.println("////////////////////////////////////");

		return sc.nextInt();
	}
	// +++++++++++ System.exit()

	public static void main(String[] args) {
		TreeSet<Commodity> set = new TreeSet<Commodity>();

		switch (Commodity.menu()) {
		case 1:
			System.out.println("Enter name: ");
			String name = sc.next();
			
			System.out.println("Enter length: ");
			double length = sc.nextDouble();
			
			System.out.println("Enter width: ");
			double width = sc.nextDouble();
			
			System.out.println("Enter height: ");
			double height = sc.nextDouble();
			
			Commodity.addGoods(set, name, length, width, height);
			break;
		case 2:
			System.out.println("Enter name of the element, which you want to remove: ");
			name = sc.next();
			Commodity.removeGoods(set, name);
			break;
		case 3:	
			System.out.println("Enter name of item which you want to replace: ");
			String nameToReplace = sc.next();
			
			System.out.println("Enter name: ");
			name = sc.next();
			
			System.out.println("Enter length: ");
			length = sc.nextDouble();
			
			System.out.println("Enter width: ");
		    width = sc.nextDouble();
			
			System.out.println("Enter height: ");
			height = sc.nextDouble();
			
			Commodity.replaceGoods(set, nameToReplace, name, length, width, height);
			break;
		case 4:
			Commodity.sortByName(set);
			break;
		case 5:
			Commodity.sortByLength(set);
			break;
		case 6:
			Commodity.sortByWidth(set);
			break;
		case 7:
			Commodity.sortByHeight(set);
			break;
		case 8:
			Commodity.printElement(0);
			break;
		case 9:
			System.out.println("exit...");
			System.exit(0);

		}

	}

}
