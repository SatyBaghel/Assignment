package temp;

import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		
		Date date = new Date();
		String dateString = date.toString();
		String datewithnospace = dateString.replaceAll("\\s", "");
		String datewithnospaceandColon = datewithnospace.replaceAll("\\:", "");
		System.out.println(datewithnospaceandColon);
		
		

	}

}
