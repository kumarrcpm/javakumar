package tamilnadu.chennai;

public class CommonManInChennai implements TrafficRules {
	public static void main(String [] args)
	{
	CommonManInChennai citizen = new CommonManInChennai();
	citizen.goByDieselVehicle();
	citizen.goByBicycle();
	}
	public void goByDieselVehicle()
	{
	System.out.println("For single person travel dont use diesel vehicle");
	}
	public void goByBicycle()
	{
	System.out.println("cycling is good for health");
	}
}
