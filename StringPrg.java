package string;

public class StringPrg {
	public static void main(String[] args) {
		String str = "23 is digit and 23 is";
		String str1 = new String();
		String[] str2 = str.split(" ");
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i)))
				str1 = str1 + str.charAt(i);
			else str1 = str1 + " ";
		}
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			try {
				if(str2[i] != " ") sum += Integer.parseInt(str2[i]);
			}catch (Exception e) {
				
			}
		}
		System.out.println(sum);
	}
}
