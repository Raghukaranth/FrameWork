package string;

public class ReverseAccount {
	public static void main(String[] args) {
		String str = "dsjnfjknsxkdjfncuejdhgnvrejdfn10:20/1212/difnkmce3825ujidmeke2f10:27/7777/dfmicewksvhnewkfk4ieejfncuhfnr";
		
		String required = str.substring(str.indexOf(":27"));
		
		int slash = required.indexOf("/");
		System.out.println(slash);
		System.out.println(required.substring(slash + 1, 8));
		
	}
}