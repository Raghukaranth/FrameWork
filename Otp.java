package string;

public class Otp {
	public static void main(String[] args) {
		String str = "djsfhvnsvnsjxksfnjcjcvns/1234/dsfhva452742dajcdbkcja";
		
		int slash = str.indexOf("/");
		System.out.println(slash);
		
		String reqString = str.substring(slash+1, 29);
		System.out.println(reqString);
	}
}
