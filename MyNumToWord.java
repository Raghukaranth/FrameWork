package string;

public class MyNumToWord {
	public static void main(String[] args) {
		char [] num = "23".toCharArray();
		int len = num.length;
		String[] onedigit = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};  
		
		String[] twodigits = new String[] {"", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};  
		  
		String[] multipleoftens = new String[] {"",  "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};  
	  
		String[] poweroftens = new String[] {"Hundred", "Thousand"};
		
		if(len == 1) System.out.println(onedigit[num[0]-'0']);
		if(len <= 2) System.out.println(twodigits[num[len-1]-'0'] + "-"+ onedigit[num[len-1]-'0']);
		if(len == 3) System.out.println(multipleoftens[num[0] - '0']);
		
		
	}

}
