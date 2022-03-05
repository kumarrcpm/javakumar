package collection;

public class Mobile implements Comparable {

	String brand,model;
	int price,ram,mp;
	
	
	public Mobile(String brand, String model, int price,
			int ram, int mp)
	{
		this.brand=brand;
		this.model=model;
		this.price=price;
		this.ram=ram;
		this.mp=mp;
	}
	
	public String toString ()
	{	// TODO Auto-generated method stub
			return this.model+""+this.price;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1;
	}

}
