package com.java.l14.setqueue;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if(o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		}else if(o1.getName().compareTo(o2.getName()) < 0){
			return -1;
		}else {
			if(o1.getYear() > o2.getYear() ) {
				return 1;
			}else if(o1.getYear() < o2.getYear()) {
				return -1;
			}
		}
		return 0;
	}

}
