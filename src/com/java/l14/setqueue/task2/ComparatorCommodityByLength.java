package com.java.l14.setqueue.task2;

import java.util.Comparator;

public class ComparatorCommodityByLength implements Comparator<Commodity> {

	@Override
	public int compare(Commodity o1, Commodity o2) {
		return o1.getLength() > o2.getLength() ? 1: -1;
	}
}
