package string;

public class PrintWordAfterGivenWord {
	public static void main(String[] args) {
		String demo="ABC Results for draw no 2888";

		System.out.println(demo.substring(demo.indexOf("no") + 3));
	}
}
