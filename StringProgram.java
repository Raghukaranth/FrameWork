package string;

public class StringProgram {
	public static void main(String[] args) {
		//String str = "a1b21@c3xyz!";
		String str = "58isdivisibleby9inb6bng8hv45";
		if(str.contains(" ")) {
			str=str.replaceAll("" , "");
		}
//		int count = 0;
//		
//		for(int i=0; i<str.length(); i++) {
//			char ch = str.charAt(i); 
//			if(ch >= 'a' && ch <= 'z') System.out.print(ch);
//			if(ch >= '1' && ch <= '99') count = count + Character.getNumericValue(ch);
//		}
//		System.out.println();
//		System.out.println(count);
		
		String str1 = "";
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) { str1 = str1 + str.charAt(i); 
			}
			else {
				str1 = str1+ " ";
				//;
			
				}
		//	str1 = str1+ " ";
			
		}
	//	System.out.println(str1);
		String[] str2 = str1.split(" ");
		//System.out.println(str2);
			int sum = 0;
		for(int i=0; i<str2.length; i++) {
			try {
			if(str2[i] != " ")
				{
				sum = sum + Integer.parseInt(str2[i]);
				}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println("sum of numbers present in string :"+sum);
	}}

