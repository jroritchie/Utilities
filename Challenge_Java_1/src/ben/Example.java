package ben;

import java.util.ArrayList;
import java.util.List;

public class Example {

	public static void main(String[] args) {

		for (int i=0;i<10;i+=2) {
			System.out.println(i);
		}
		
		List<String> myList = new ArrayList<String>();
		myList.add("Apple");
		myList.add("Orange");
		myList.add("Lemon");
		
		for (String s: myList) {
			System.out.println(s);
		}
		
		
	}

}
