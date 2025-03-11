package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SetPractice {
	public static void main(String[] args) {
		 HashMap<Integer, String> map = new HashMap<Integer, String>();
		 
		 map.put(1, "Raghavendra");
		 map.put(2, "john");
		 map.put(3, "Steve");
		 
		 Set<Entry<Integer, String>> set = map.entrySet();
		 Iterator<Entry<Integer, String>> itr = set.iterator();
		 
		 while(itr.hasNext()) {
			 Entry<Integer, String> entry = itr.next();
			 System.out.println(entry.getKey()+" "+entry.getValue());
		 }
	}
}
