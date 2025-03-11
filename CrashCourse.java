package crash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CrashCourse {
	//combination of num
	

	public static void combinationOfNum() {
		int a[] = {6, 3, 1, 2, 9, 8, 7, 4};
		for(int i=0; i<a.length; i++) {
			for(int j=1; j<a.length; j++) {
				int num = a[i] + a[j];
				if(num == 11) System.out.println(a[i] +" "+ a[j]);
			}
		}
	}

	public static void reverseString(){
		String str = "India";

		for(int i=str.length()-1; i>=0; i--) 
			System.out.print(str.charAt(i));
	}

	public static void removeSpaces() {
		String str = "Saket Saurav        is a QualityAna    list";
		String[] split = str.split(" ");

		for(int i=0; i<split.length; i++) 
			System.out.print(split[i]);
	}

	public static void removeWithReplace() {
		String str1 = "Saket Saurav        is an Autom ation Engi ne      er";

		char[] chars = str1.toCharArray();

		StringBuffer sb = new StringBuffer();

		for(int i=0; i<chars.length; i++) {
			if((chars[i] != ' ') && (chars[i] != '\t'))
				sb.append(chars[i]);
		}
		System.out.println(sb);
	}

	public static void reverseWords() {
		String str = "welcome to TestYantra";
		String[] split = str.split(" ");

		for(int i=0; i<split.length; i++) {
			String string = split[i];
			for(int j=string.length()-1; j>=0; j--) {
				System.out.print(string.charAt(j));
			}
			System.out.print(" ");
		}
	}

	public static void swapItAndListItWordsInString() {
		String str = "welcome to TestYantra software";
		String[] split = str.split(" ");
		String temp = split[0];
		split[0] = split[split.length-1];
		split[split.length-1] = temp;

		for(int i=0; i<=split.length; i++) {
			System.out.print(split[i-1]+ " ");
		}
	}

	public static void occuranceOfChars() {
		String str = "testyantra";
		char[] string = str.toCharArray();
		int count = 0;

		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i)  == 't') {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void otpInString() {
		String str = "Hi your OTP is 34567 please done share it";

		//System.out.println(str.replaceAll("[^0-9]", ""));
		for (int i = 0; i < str.length(); i++) {
			 boolean result = Character.isDigit(str.charAt(i));
			 if(result==true) {
				 System.out.print(str.charAt(i));
			 }
		}
	}

	public static void checkWordIsPresent() {
		String str = "your Account balance is 12345";
		String string = "Account";
		String[] split = str.split(" ");

		if(str.contains(string)) System.out.println("present");
	}





	public static void stringBufferReverse() {
		StringBuffer string = new StringBuffer("Raghavendra");;
		System.out.println(string.reverse());
	}

	public static void stringBuilder() {
		String str = "Raghavendra";
		StringBuilder builder = new StringBuilder().append(str).reverse();
		System.out.println(builder);
	}

	public static void reverseStringArray() {
		String str = "Raghavendra";
		char[] string = str.toCharArray();

		for(int i=string.length-1; i>=0; i-- ) {
			System.out.print(string[i]);
		}
	}

	public static String recursiveMethod(String str) {
		if((null == str) || (str.length() <= 1))
			return str;
		return recursiveMethod(str.substring(1))+str.charAt(0);
	}

	public static void printPyramid() {
		int n = 5;
		int rowCount = 1;
		for (int i = n; i > 0; i--)
		{
			//Printing i spaces at the beginning of each row

			for (int j = 1; j <= i; j++)
			{
				System.out.print(" ");
			}

			//Printing 'rowCount' value 'rowCount' times at the end of each row

			for (int j = 1; j <= rowCount; j++)
			{
				System.out.print(rowCount+" ");
			}

			System.out.println();

			//Incrementing the rowCount

			rowCount++;
		}
	}

	public static void swapTwoNumsUsingThirdVar() {
		int a = 5, b = 6;
		int c;

		c = a;
		a = b;
		b = c;

		System.out.println(a + ", "+ b);
	}

	public static void swapTwoNumWithoutUsingThirdVar() {
		int a = 5, b = 6;

		a = a+b;
		b = a-b;
		a = a-b;

		System.out.println(a + ", "+ b);
	}

	public static void substringSame() {
		String str = "Raghavendra";
		System.out.println(str.substring(1, 1));
	}

	public static void hashCountWords() {
		String str = "This this is is done by Saket Saket";
		String[] split = str.split(" ");
		HashMap<String,Integer> map = new HashMap<String,Integer>();

		for(int i=0; i<split.length; i++) {
			if(map.containsKey(split[i])) {
				int count = map.get(split[i]);
				map.put(split[i], count+1);
			}
			else {
				map.put(split[i], 1);
			}
			System.out.println(map);
		}
	}

	public static boolean primeNum() {
		int n = 5;
		if(n <= 1) return false;

		for(int i=2; i<Math.sqrt(n); i++) {
			if (n%i == 0) return false;
		}
		return true;
	}

	public static void threeToOneMap() {
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "Java-Selelnium");

		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(2, "Java-Selenium-API");

		HashMap<Integer, String> map3 = new HashMap<Integer, String>();
		map3.put(3, "Java-Selenium-Appium");



		Map<Integer, String> map4 = Stream.of(map1, map2, map3)
				.flatMap(map -> map.entrySet().stream())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println(map4);
	}

	public static void palindrome() {
		String org = "poop", rev = "";

		for(int i=org.length()-1; i>=0; i--) {
			rev = rev + org.charAt(i);
		}

		if(org.equals(rev)) 
			System.out.println("palendrome");
		else System.out.println("not palendrome");
	}

	public static void fibonacci() {
		int a = 0, b = 0, c = 1;
		int num = 10;
		for (int i=0; i<num; i++) {
			a = b;
			b = c;
			c = a+b;
			System.out.println(a + "");
		}
	}

	public static void armstrong() {
		int c=0, a, temp;
		int n=153;

		temp = n;
		while(n>0) {
			a = n%10;
			n = n/10;
			c = c+(a*a*a);
		}
		if(temp == c) {
			System.out.println("armstrong");
		}
		else System.out.println("not");
	}

	public static void correctWord() {
		String str = "your tnuocca is transfered";
		String[] split = str.split(str);

		System.out.println(str.replace("tnuocca", "account"));
	}

	public static void digitPalendrome() {
		int num = 434;
		int rev = 0;

		while(num > 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num /= 10;
		}
		

	}

	public static void sqareRoot() {
		int num = 2;

		System.out.println(Math.sqrt(num));
	}

	public static String reverseWords(String sentence) { 
		List< String> words = Arrays.asList(sentence.split("\\s"));
		Collections.reverse(words); StringBuilder sb = new StringBuilder(sentence.length());

		for(int i=words.size()-1; i>=0; i--) {
			sb.append(words.get(i));
			sb.append(' ');
		}
		return sb.toString().trim();
	}

	public static void isArmstrong() {
		int number = 371, originalNumber, remainder, result = 0;

		originalNumber = number;

		while (originalNumber != 0)
		{
			remainder = originalNumber % 10;
			result += Math.pow(remainder, 3);
			originalNumber /= 10;
		}

		if(result == number)
			System.out.println(number + " is an Armstrong number.");
		else
			System.out.println(number + " is not an Armstrong number.");
	}

	public static void removeDup() {
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(1);
		primes.add(4);
		primes.add(3);

		Set<Integer> primesWithoutDup = new LinkedHashSet<>(primes);
		primes.clear();
		primes.addAll(primesWithoutDup);

		System.out.println(primes);
	}

	public static void listUsingWhile() {
		ArrayList list = new ArrayList();
		list.add("20");
		list.add("30");
		list.add("40");

		Iterator itr = list.iterator();

		while(itr.hasNext()) System.out.print(itr.next()+" ");
		System.out.println();
		for (Object obj : list) {
			System.out.print(obj+" ");
		}
		System.out.println();
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
	}

	public static void leapYear() {
		int year = 2012;

		if((year%400) == 0 || (year % 100)!=0)
			System.out.println("leap year");
		else System.out.println("not leap year");
	}

	public static void exceldata() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Raghavendra");
		list.add("uma");
		list.add("Sreenivas");

		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == "uma") {
				System.out.println(list.get(i));
			}
		}
	}
	
	public static void chocolate() {
		String str = "your account is debitted";
		String string = "amount";
		String[] split = str.split(" ");
		
		for(int i=0; i<split.length-1; i++) {
			if(split[i].equalsIgnoreCase(string)) System.out.println("present");
		}
	}
	
	public static void secondLargestArray() {
		int[] arr = {4, 2, 4, 1, 5, 2, 8};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("The second largest number is: " + secondLargest);
	}
	
	public static void reverseInPosition() {
		String str = "Raghavendra sudarshan";
		String[] split = str.split(" ");
		
		for (String string : split) {
			for(int i=string.length()-1; i>=0; i--) {
				System.out.print(string.charAt(i));
			}
			System.out.print(" ");
		}
	}
	
	public static void segrigateAlphabets() {
		String str = "bacbacabbabaaba";
		
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		
		for(int i=0; i<str.length()-1; i++) 
			set.add(str.charAt(i));
		
		for (Character ch : set) {
			for(int i=0; i<str.length(); i++) {
				if(ch == str.charAt(i)) {
					System.out.println(ch);
				}
			}
		}
	}
	
	public static void countWithPos() {
		String str = "AAbACCbdEEAA";
		
		for(int i=0; i<str.length(); i ++) {
			int count = 1;
			for(int j=i+1; j<str.length(); j++) {
				if(str.charAt(i)==str.charAt(j)) {
					count++; 
					i++;
				} else break;
			}System.out.println(str.charAt(i)+""+count);
		}
	}
	
	public static void maxCharInString() {
		String str = "my name is Raghavendra";
		String[] split = str.split(" ");
		String maxLen = split[0];
		
		for(int i=0; i<split.length; i++) {
			if(maxLen.length() < split[i].length()) maxLen = split[i];
		}
		System.out.println(maxLen +" "+ maxLen.length());
	}
	
	
	public static boolean consicutiveNumbers() {
		int[] nums = {1, 2 ,5, 0, 4, 3, 6};
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-1; i++) {
			if(nums[i]+1 != nums[i+1]) 
				return false;
		}
		return true;
	}
	
	public static int factorial(int n) {
		if(n == 0) return 1;
		else return n * factorial(n-1);
	}
	
	public static String reverseRecurse(String str) {
		if(str.isEmpty()) {
			System.out.println("string is empty");
			return str;
		}
		else 
		return reverseRecurse(str.substring(1))+str.charAt(0);
	}
	
	
	public static void primeNumber() {
		int n = 2 , i = 2;
		
		while(i<=n) {
			if(n % i == 0) 
				break;
			else i++;
		}
		System.out.println((i == n)?"prime":"not prime");
	}
	
	public static void removeString() {
		String str = "my name is Raghavendra";
		String[] split = str.split(" ");
		String string = "my";
		
		for(int i=0; i<split.length-1; i++) {
			if(split[i].equals(string))
				System.out.println(str.replace(split[i], ""));
		}
	}
	
	public static void duplicateChars() {
		StringBuffer str = new StringBuffer().append("Raghavnndra").reverse();
		System.out.println(str);
		}
	
	public static void subArray(int A[], int n) {
		int maxSum = Integer.MIN_VALUE;

        for (int i=0;i<=n-1;i++){
            for (int j=i;j<=n-1;j++) {
                int currSum = 0;
                for(int k=i;k<=j;k++){
                    currSum += A[k];
                }
                maxSum = Math.max(maxSum,currSum);
            }
        }
        System.out.println(maxSum);
    }

	public static void occurance() {
		String str = "Raghavendra";
		String lower = str.toLowerCase();
		//int count =0;
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i=0; i<lower.length(); i++) {
			hashSet.add(lower.charAt(i));
		}
		System.out.println(hashSet);
		for (Character character : hashSet) {
			int count = 0;
			for(int j=0; j<lower.length(); j++) {
				if(character == lower.charAt(j)) count++;
			}
			System.out.println(character+" "+count);
		}
	}
	
	public static void occuranceEachChar() {
		String str = "raghavendra";
		String completed = "";
		for(int i=0;i<str.length();i++) {
		    int count=0; // move count to here so it counts from zero every iteration of outer loop
		    for(int j=i;j<str.length();j++) {
		        if(str.charAt(i)==str.charAt(j)) {
		            count++; 
		        }
		    }
		    String s = String.valueOf(str.charAt(i));
		    if(!completed.contains(s)) {
		    	completed += str.charAt(i);
		    	System.out.println(str.charAt(i)+" "+count);
		    }
		}
	}
	
	public static void occuranceEachMap() {
		String str = "raghavendra";
		char[] toChar = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap();
		
		for (char ch : toChar) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}
				else map.put(ch, 1);
		}
		map.forEach((k, v)-> System.out.println(k+": "+v+" "));
	}
	
	public static void secondMaxArray() {
		String str = "4PREP2INSTAA6";
		char[] charStr = str.toCharArray();
		int num = 0;
		for(int i=0; i<str.length(); i++) {
			if(Character.isDigit(str.charAt(i)))
				num += Character.getNumericValue(str.charAt(i));
		}
		System.out.println(num);
	}
	
	public static void dupRemoveArray() {
		int arr[] = {1, 2, 3, 2, 4, 1, 5, 6, 1, 5, 2};
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			try {
			if(arr[i] != arr[i+1]) {
				System.out.println(arr[i]);
			}
			}catch (Exception e){
				System.out.println(arr[arr.length-1]);
			}
		}
	}
	
	public static void palendrome() {
		int arr[] = {4, 5, 2, 3, 4, 1, 6, 4, 3};
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		
		System.out.println(set);
	}

	public static void cisco() {
		String str = "cisco is in india at in bangalore";
		
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<str.length(); j++) {
				String string = str.substring(i, j);
				if (string.equals("in"))
					str = str.substring(0, i)+"at"+str.substring(i+2);
			}
		}
		System.out.println(str);
	}
	
	public static int fact(int n) {
		if(n == 0) return 1;
		else return n * fact(n-1);
	}

	public static void main(String[] args) {
		dupRemoveArray();
	}
}


