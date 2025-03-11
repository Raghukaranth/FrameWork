package string;

public class Coindcx {
	public static void main(String[] args) {
		String str = "Hi 567890 is your otp";
			
		String string = str.replaceAll("[^0-9]", "");
		System.out.println(string);
		}
	}

