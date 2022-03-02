package collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList al = new ArrayList();
		System.out.println("Before add Size of Array List = " + al.size());
		al.add(5);
		al.add("kumar");
		al.add(true);
		al.add(3.14f);
		System.out.println(al);
		System.out.println("After add size of array List = " + al.size());
		// For each Loop for Print object separately
		for (Object obj : al) {
			System.out.println(obj);
		}
		// For print class name
		for (Object obj : al) {
			System.out.println(obj.getClass().getName());
		}
		// print only string object
		for (Object obj : al) {
			String s = obj.getClass().getName();
			if (s.equals("java.lang.String")) {
				System.out.println(obj);
			}
		}
		// print float object
		for (Object obj : al) {
			String f = obj.getClass().getName();
			if (f.equals("java.lang.Float")) {
				System.out.println(obj);
			}
		}

	}

}