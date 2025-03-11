package string;

import java.util.LinkedHashSet;

public class RemoveDuplicatesAbhimanSir {
	//remove a
	//count a
	//reverse it
	// print 1st string and 4th string
	public static void main(String[] args) {
		String str = "Raghavendra karanth raghavendra Karanth";
		char[] string = str.toCharArray();
		int count = 0;
		
		for(int i=0; i<string.length; i++)
			if(string[i] == 'a')
				count++;
		System.out.println(count);
		
		System.out.println(str.replace("a", ""));
		
		for(int i=string.length-1; i>=0; i--) {
			System.out.print(string[i]);
		}
		System.out.println();
		
//		System.out.println(str.substring(0, 11));
//		System.out.println(str.substring(32));
		
		String[] split = str.split(" ");

		System.out.println(str.replace(" ",""));
	}
}
