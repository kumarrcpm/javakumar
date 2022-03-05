package collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList a = new ArrayList();
		a.add(5);
		a.add(10);
		a.add(17);
		a.add(20);
		
		// type casting
		for (Object o : a) {
			Integer i = (Integer) o;
			if (i % 2 == 0)
				System.out.println(i);
		}

		ArrayList b = new ArrayList();
		b.add("Kumar");
		b.add("ram");
		b.add("kumar");
		b.add("ramkumar");
		for (Object o : b) {
			String s = (String) o;
			if (s.endsWith("r")) {
				System.out.println(s);
			}
		}
		for (Object o : b) {
			String s = (String) o;
			if (s.length() == 5) {
				System.out.println(s);
			}
		}
		b.remove("ram");
		System.out.println(b);
		b.add(1, "bcd");
		System.out.println(b);

		ArrayList c = new ArrayList();
		c.addAll(b);
		System.out.println(c);
		System.out.println(c.contains("bcd"));
		c.add("a");
		System.out.println(c);
		c.retainAll(b);
		System.out.println(c);
		List l = c.subList(1, 3);
		System.out.println(l);

		Object[] ob = b.toArray();
		for (Object o : ob) {
			System.out.println(o);
		}
	}

}
