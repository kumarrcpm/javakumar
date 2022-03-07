package generics;

import java.util.ArrayList;
import java.util.Collections;

public class GenericsDemo {

	public static void main(String[] args) {
		Generic g = new Generic(1234);
		g.display();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(5);
		al.add(52);
		al.add(12);
		al.add(30);
		GenericsDemo gm = new GenericsDemo();
		gm.sort(al);

		
		
	}

	private void sort(ArrayList al) {
		Collections.sort(al);
	//	System.out.println(al);
	}

}
