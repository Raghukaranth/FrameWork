package string;

public class MaxCharsOccur {
	static char max_occuring_char(String str)
	{
		int arr[] = new int[250];
		int l = str.length();
		for (int i = 0; i < l; i++)
		{			
			arr[str.charAt(i)]++;
		}
		int max = -1;
		char res = ' ';
 
		for (int i = 0; i < l; i++)
		{
			if (max < arr[str.charAt(i)])
			{
				max = arr[str.charAt(i)];
				res = str.charAt(i);
			}
		}
 
		return res;
	}
	public static void main(String[] args)
	{
		String str = "java exercises";
		System.out.println("Given String is: " + str);
		System.out.println("Max Occurring Character in String is: " + max_occuring_char(str));
	}
}
