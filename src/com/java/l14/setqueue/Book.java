package com.java.l14.setqueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Book implements Comparable<Book>{
	private String name;
	private int year;

	public Book(String name, int year) {
		super();
		this.name = name;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", year=" + year + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
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
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Book o) {
		return name.compareTo(o.getName());
	}

	public static void main(String[] args) {
		TreeSet<Book> set  = new TreeSet<Book>(new BookComparator());
		
		set.add(new Book("Java", 2015));
		set.add(new Book("PHP", 2013));
		set.add(new Book("C", 2010));
		set.add(new Book("C", 2019));
		set.add(new Book("Python", 2018));
		set.add(new Book("Assembler", 2003));
		
		System.out.println("Unsorted set:" + set);
		System.out.println("/////////////////////////");
		
		for(Book book:set) {
			System.out.println(book);
		}
	}
}
