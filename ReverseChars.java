package string;

public class ReverseChars {
	public static void main(String[] args) {
		String str = "Hi Hello Welcome Bye";
		String[] split = str.split(" ");
		
		for(int i=0; i<split.length; i++) {
			String string = split[i];
			for(int j=string.length()-1; j>=0; j--) {
				System.out.print(string.charAt(i));
			}
			System.out.print(" ");
		}
	}
}
