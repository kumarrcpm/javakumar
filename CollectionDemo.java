package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList al = new LinkedList();
		CollectionDemo cd = new CollectionDemo();
		//cd.list();
		//cd.arrays();
		//cd.mobilesort();
		//cd.iteratorDemo();
		//cd.mapDemo();
		//cd.iterator();
		//cd.hashSet();
		//cd.listToset();
		//cd.treeset();
		//cd.hashmap();
		//cd.separateEntrySet();
		//cd.linkedhashmap();
		cd.treemap();
		
		
		
		
		
		
	}

	private void treemap() {
		// TODO Auto-generated method stub
		TreeMap tm = new TreeMap();
		tm.put("idli", 20);
		tm.put("dosai", 25);
		tm.put("vadai", 10);
		tm.put("biriyani", 60);
		tm.put("tea",10);
		tm.put("idli", 25);
		System.out.println(tm);
	}

	private void linkedhashmap() {
		// TODO Auto-generated method stub
		LinkedHashMap lhm = new LinkedHashMap();
		lhm.put("idli", 20);
		lhm.put("dosai", 25);
		lhm.put("vadai", 10);
		lhm.put("biriyani", 60);
		lhm.put("tea",10);
		lhm.put("idli", 25);
		System.out.println(lhm);
	}

	private void separateEntrySet() {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		hm.put("idli", 20);
		hm.put("dosai", 25);
		hm.put("vadai", 10);
		hm.put("biriyani", 60);
		hm.put("tea",10);
		hm.put("idli", 25);
		System.out.println(hm);
		Set s = hm.entrySet();
		for(Object ob : s)
		{
			Map.Entry me = (Map.Entry)ob;
			if(me.getKey().equals("dosai"))
				//System.out.println(me.getValue());
				me.setValue(50);
			//System.out.println(ob);
		}
		System.out.println(hm);

	}

	private void hashmap() {
		// TODO Auto-generated method stub
		
		HashMap hm = new HashMap();
		hm.put("idli", 20);
		hm.put("dosai", 25);
		hm.put("vadai", 10);
		hm.put("biriyani", 60);
		hm.put("tea",10);
		hm.put("idli", 25);
		System.out.println(hm);
		Set s =hm.keySet();
		System.out.println(s);
		Collection c =hm.values();
		System.out.println(c);
		Set p =hm.entrySet();
		System.out.println(p);
		System.out.println(hm.containsKey("biriyani"));
		System.out.println(hm.containsValue(10));
		System.out.println(hm.get("dosai"));
		hm.remove("idli");
		System.out.println(hm);
		
		
		
		
		
	}

	private void treeset() {
		// TODO Auto-generated method stub
		TreeSet ts = new TreeSet();
		ts.add(10);
		ts.add(3);
		ts.add(30);
		ts.add(20);
		ts.add(10);
		ts.add(30);
		System.out.println(ts);
	}

	private void listToset() {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(10);
		al.add(40);
		al.add(30);
		System.out.println(al);
		LinkedHashSet lh = new LinkedHashSet();
		for(Object a: al)
		{
			boolean result = lh.add(a);
			if(result==false)
			{
				System.out.println("Duplicate = "+a);
			}
		}
		
	}

	private void hashSet() {
		// TODO Auto-generated method stub
		LinkedHashSet hs = new LinkedHashSet();
		hs.add(10);
		hs.add(20);
		hs.add(15);
		hs.add(10);
		System.out.println(hs);
		Iterator i =hs.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}

	private void iterator() {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.add(10);
		ll.add(15);
		ll.add(20);
		ll.add(15);
		Iterator i =ll.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}

	private void mapDemo() {
		// TODO Auto-generated method stub
		TreeMap hm = new TreeMap();
		hm.put("idli", 10);
		hm.put("dosai", 10);
		hm.put("pongal", 10);
		hm.put("idli", 20);
		System.out.println(hm);
		Set s = hm.keySet();
		System.out.println(s);
		Collection c = hm.values();
		System.out.println(c);
		Set es = hm.entrySet();
		System.out.println(es);
	System.out.println(hm.containsKey("dosai"));
	System.out.println(hm.containsValue(10));
	System.out.println(hm.get("dosai"));
	hm.remove("idli");
	System.out.println(hm);
	
	Set s1 = hm.entrySet();
	for(Object ob: s1)
	{
		Map.Entry me =(Map.Entry)ob;
		System.out.println(me.getKey()+""+me.getValue());
	if(me.getKey().equals("dosai"))
	{
		//System.out.println(me.getValue());
		me.setValue(25);
	}
		
	}
	System.out.println(hm);

	}

	private void iteratorDemo() {
		// TODO Auto-generated method stub
		
		TreeSet al = new TreeSet();
		al.add(10);
		al.add(5);
		al.add(11);
		al.add(3);
		al.add("kumar");
		System.out.println(al);
		
		
	}

	private void mobilesort() {
		// TODO Auto-generated method stub
		Mobile m1= new Mobile("realme","s2",20000,8,10);
		Mobile m2= new Mobile("real","a2",10000,4,6);
		Mobile m3= new Mobile("redmi","b2",2000,2,15);
		Mobile m4= new Mobile("re","c2",3000,10,11);
		ArrayList al = new ArrayList();
		al.add(m1);
		al.add(m2);
		al.add(m3);
		al.add(m4);
		System.out.println("Before Sorting");
		for(Object ob: al)
		{
			Mobile m = (Mobile)ob;
			System.out.println(m);
		}
	System.out.println(al);
	Collections.sort(al);
	System.out.println(al);
	}

	private void arrays() {
	String [] names= {"aaa","xxx","eee","bbb"};
	///System.out.println(Arrays.binarySearch(names,"ram"));
	System.out.println("Before Sorting");
	for(String name : names)
	{
		System.out.print(name+" ");
	}
	System.out.println();
	System.out.println("After Sorting");
	MyComparatorDemo mcd = new MyComparatorDemo();
	Arrays.sort(names,mcd);
	for(String name : names)
	{
		System.out.print(name+" ");
	}
	}
	

	/*
	 * private void list() { // TODO Auto-generated method stub
	 * System.out.println("Before add Size of Array List = " + al.size());
	 * al.add(5); al.add("kumar"); al.add(true); al.add(3.14f);
	 * System.out.println(al); System.out.println("After add size of array List = "
	 * + al.size()); // For each Loop for Print object separately for (Object obj :
	 * al) { System.out.println(obj); } // For print class name for (Object obj :
	 * al) { System.out.println(obj.getClass().getName()); } // print only string
	 * object for (Object obj : al) { String s = obj.getClass().getName(); if
	 * (s.equals("java.lang.String")) { System.out.println(obj); } } // print float
	 * object for (Object obj : al) { String f = obj.getClass().getName(); if
	 * (f.equals("java.lang.Float")) { System.out.println(obj); } }
	 * 
	 * } }
	 */

}