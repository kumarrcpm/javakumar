package india.newDelhi;

import tamilnadu.chennai.TrafficRules;

public class CommonManInDelhi implements TrafficRules, TrafficRulesDelhi {
	public static void main(String [] args)
	{
	CommonManInDelhi DelhiWala = new CommonManInDelhi();
	DelhiWala.goByDieselVehicle();
	DelhiWala.goByBicycle();
	DelhiWala.dontGoByDieselVehicle();

	}
	public void goByBicycle()
	{
		System.out.println("Use Bicycle");
	}
	public void dontGoByDieselVehicle()
	{
	System.out.println("Use only public transport");
	}
	public void goByDieselVehicle()
	{
		System.out.println("No Air Pollution use diesel vehicle");
	}
}
