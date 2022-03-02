package fileReading;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		RegexDemo user = new RegexDemo();
		user.regex();
		user.regex1();
		user.regex2();
	}
	private void regex2() {
		// TODO Auto-generated method stub
		String input = "kumar kumarram kumarrcpm";
		Pattern p = Pattern.compile("^kumar");
		Matcher m = p.matcher(input);
		boolean found = m.find();
		while (found == true) {
			System.out.println(m.group());
			found = m.find();
		}
	}
	private void regex1() {
		// TODO Auto-generated method stub
		String input = "kumar kumarram kumarramasamy kumarrcpm";
		Pattern p = Pattern.compile("[kumar]");
		Matcher m = p.matcher(input);
		boolean found = m.find();
		while (found == true) {
			System.out.print(m.group() + " ");
			found = m.find();
		}
	}
	private void regex() {
		// TODO Auto-generated method stub
		String input = "kumar kumarram kumarramasamy kumarrcpm";
		Pattern p = Pattern.compile("kumar");
		Matcher m = p.matcher(input);
		boolean found = m.find();
		while (found == true) {
			System.out.println(m.group());
			found = m.find();
		}
	}

}
