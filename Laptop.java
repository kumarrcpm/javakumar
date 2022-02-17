package arrayBasics;

public class Laptop {

	String brand;
	
public Laptop(String brand)
{
	this.brand=brand;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Laptop l1=new Laptop("Dell");
Laptop l2=new Laptop("Lenovo");
		System.out.println(l1);
		System.out.println(l2);
		
	}
public String toString()
{
	return "Hi";
}
}
