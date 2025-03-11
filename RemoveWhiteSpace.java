package string;

public class RemoveWhiteSpace {
	public static void main(String[] args) {
		String str = "Remove The Space";
		
		 str = str.replaceAll("\\s+", "");    
		System.out.println(str);
	}
}
