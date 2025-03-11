package string;

public class ReverseString {
	public static void main(String[] args) {
		String word = "Raghavendra";
		String string = new StringBuffer(word).reverse().toString();
		
		System.out.println(string);
	}
}
