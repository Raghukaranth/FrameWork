package string;

public class OTPCoinDCX {
	public static void main(String[] args) {
		String str = "Radar";
//		String string = str.replaceAll("[^0-9]", "");
//		String[] strArr = str.split(" ");
//		System.out.println(string);
//		
//		for(int i=str.length()-1; i>0; i--) {
//			System.out.print(str.charAt(i));
//		}
//		
//		for(int i=str.length()-1; i>0; i--) 
//			System.out.print(strArr[i]);
//		
//		for (String string2 : strArr) {
//			for(int i=string2.length()-1; i>=0; i--) {
//				System.out.print(string2.charAt(i));
//			}
//			System.out.print(" ");
//		}
		
		String rev = "";
		int strlen = str.length()-1;
		
		for(int i=strlen; i>=0; --i) 
			rev = rev + str.charAt(i);
		
		if(str.toLowerCase().equals(rev.toLowerCase()))
			System.out.println("palendrome");
		else
			System.out.println("not palendrome");
		
	}
}
