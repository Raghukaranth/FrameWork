package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SetPrg {
	public static void main(String[] args) {
		String[] str = {"india", "uk", "London"};
		String[] str1 = {"uk", "London", "USA"};
		
		List<String> set1 = new ArrayList<String>();
		for (String string : set1) {
			set1.add(string);
		}
		
		System.out.println(set1);
	}
}
