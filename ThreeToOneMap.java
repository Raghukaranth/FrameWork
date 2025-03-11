package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeToOneMap {
	public static void main(String[] args) {
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "Java-Selelnium");
		
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(2, "Java-Selenium-API");
		
		HashMap<Integer, String> map3 = new HashMap<Integer, String>();
		map3.put(3, "Java-Selenium-Appium");
		
		
		
		Map<Integer, String> map4 = Stream.of(map1, map2, map3)
				.flatMap(map -> map.entrySet().stream())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(map4);
	}
}
