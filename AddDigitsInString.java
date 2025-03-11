package string;

public class AddDigitsInString {
	public static void main(String[] args) {
		String str = "23 is added by  3";
		String str1 = new String();
		String[] str2 = str.split(" ");
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				str1 = str1 + str.charAt(i);
			}else {
				str1 = str1 + " ";
			}
		}
		System.out.println(str1);
//		int sum = 0;
//		for(int i=0; i<str.length(); i++) {
//			try {
//				if(str2[i] != " ")
//					sum = sum +Integer.parseInt(str2[i]);
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//			}
//		}System.out.println(sum);
	}
}
