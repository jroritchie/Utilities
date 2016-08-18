package ben;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		
		int i = 1;
		int j = 2;
		
		myList.add(new Integer(i));
		myList.add(j);
		
		int k = myList.get(0);
		int l = myList.get(1).intValue();
		
		
	}

}
