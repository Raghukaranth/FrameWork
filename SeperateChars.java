package string;

public class SeperateChars {
	public static void main(String[] args) {
		StringBuffer caps = new StringBuffer();
		StringBuffer low = new StringBuffer();
		StringBuffer num = new StringBuffer();
		String str = "Java1T2Point3";
		
		for(int i=0; i<str.length();i++) {
			if(Character.isUpperCase(str.charAt(i)))
				caps.append(str.charAt(i));
			else if(Character.isLowerCase(str.charAt(i)))
				low.append(str.charAt(i));
			else if(Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));
		}
		System.out.println(num);
		System.out.println(caps);
		System.out.println(low);
	}
}
