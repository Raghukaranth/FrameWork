package string;

public class AspireScreening {
	public static void main(String[] args) {

		String str = "Iam Working In Testyantra";
		String[] split = str.split(" ");
			
			for (String string : split) {
				for(int i=string.length()-1; i>=0; i--)
					System.out.print(string.charAt(i));
				System.out.print(" ");
			}		
	}
}
