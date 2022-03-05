package collection;

import java.util.Comparator;

public class MyComparatorDemo implements Comparator {

	@Override
	public int compare(Object ob1, Object ob2) {
		// TODO Auto-generated method stub
	//	System.out.println(ob1);
	//	System.out.println(ob2);

		String s1 = (String)ob1;
		String s2 = (String)ob2;
		int result =s1.compareTo(s2);
		return -result;
	}


}
