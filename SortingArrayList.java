package collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortingArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(5);
		list.add(2);
		
		for (Integer i : list) {
			System.out.println(i);
		}

		Collections.sort(list);
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
