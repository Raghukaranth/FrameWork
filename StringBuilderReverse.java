package string;

public class StringBuilderReverse {
	public static void main(String[] args) {
		String str = "this is OTP 567890 please do not share it wth any one";

		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i)))
				System.out.print(str.charAt(i));
		}
	}
}
