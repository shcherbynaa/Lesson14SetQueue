package com.java.l14.setqueue.task2;

import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Commodity {

	String name;
	private double length;
	private double width;
	private double height;
	public static Scanner sc = new Scanner(System.in);
	public static TreeSet<Commodity> set = new TreeSet<Commodity>(new ComparatorCommodityByName());

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
		Iterator<Commodity> iterator = set.iterator();
		System.out.println("NAME: " + name);

		while (iterator.hasNext()) {
			Commodity next = iterator.next();
			System.out.println("TEST");
			if (next.getName().equals(name)) {
				System.out.println("AAAAAAAAAa");
				System.out.println(next.getName());
				iterator.remove();
			}
		}
	}

	public static void replaceGoods(TreeSet<Commodity> set, String nameToReplace, String name, double length,
			double width, double height) {
		Iterator<Commodity> iterator = set.iterator();
		System.out.println("NAME: " + name);

		while (iterator.hasNext()) {
			Commodity next = iterator.next();
			if (next.getName().equals(nameToReplace)) {
				next.setName(name);
				next.setLength(length);
				next.setWidth(width);
				next.setHeight(height);
			}
		}
	}

	public static void sortByName(TreeSet<Commodity> set) {
		ComparatorCommodityByName comparator = (ComparatorCommodityByName) set.comparator();
		System.out.println("Sorted By Name:");
		for (Commodity c : set) {
			System.out.println(c);
		}
	}

	public static void sortByLength(TreeSet<Commodity> set) {
		TreeSet<Commodity> set1 = new TreeSet<>(new ComparatorCommodityByLength());
		set1.addAll(set);

		System.out.println("Sorted By Length:");

		for (Commodity c : set1) {
			System.out.println(c);
		}
	}

	public static void sortByWidth(TreeSet<Commodity> set) {
		TreeSet<Commodity> set1 = new TreeSet<>(new ComparatorCommotityByWidth());
		set1.addAll(set);

		System.out.println("Sorted By Width:");

		for (Commodity c : set1) {
			System.out.println(c);
		}
	}

	public static void sortByHeight(TreeSet<Commodity> set) {
		TreeSet<Commodity> set1 = new TreeSet<>(new ComparatorCommotityByHeight());
		set1.addAll(set);

		System.out.println("Sorted By Height:");

		for (Commodity c : set1) {
			System.out.println(c);
		}
	}

	public static void printElement(String i) {
		Iterator<Commodity> iterator = set.iterator();
		while (iterator.hasNext()) {
			Commodity next = iterator.next();
			if (next.getName().equals(i)) {
				System.out.println(next.toString());
			}
		}
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
	
	public static void main(String[] args) {
		while (true) {

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
				if (set.isEmpty() != true) {
					Commodity.removeGoods(set, name);

				} else {
					System.out.println("The set is empty");
				}
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
				System.out.println("Enter name of item which you want to see: ");
				Commodity.printElement(sc.next());
				break;
			case 9:
				System.out.println("exit...");
				System.exit(0);
			}
		}
	}
}
