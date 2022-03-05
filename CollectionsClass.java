package collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
CollectionsClass c = new CollectionsClass();

c.demo();
	}

	private void demo() {
		// TODO Auto-generated method stub
		Mobile m1= new Mobile("realme","s2",20000,8,10);
		Mobile m2= new Mobile("redmi","a2",10000,4,6);
		Mobile m3= new Mobile("samsung","b2",12000,2,15);
		Mobile m4= new Mobile("moto","c2",13000,10,11);
		
		ArrayList al = new ArrayList();
		al.add(m1);
		al.add(m2);
		al.add(m3);
		al.add(m4);
		for(Object o:al)
		{
			Mobile m = (Mobile)o;
			System.out.println(m);
		}
		
		Collections.sort(al);
		System.out.println(al);
	}

}
