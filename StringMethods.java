package string;

public class StringMethods {
	public static void main(String[] args) {
		String str = "Raghavendra Karanth";
		String[] split = str.split(" ");
		
		for(int i=split.length-1; i>=0; i--)
			System.out.print(split[i]+" ");
	}

}
