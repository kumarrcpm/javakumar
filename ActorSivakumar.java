
public class ActorSivakumar implements Actor {
	public ActorSivakumar(int amount, String brand)
	{
	System.out.println(amount + brand);
	}
	public ActorSivakumar()
	{
	System.out.println("Zero argument constructor for ac");
	}
	public static String address="coimbatore";
	public static void main(String [] args)
	{
	ActorSivakumar as = new ActorSivakumar(65, "AudiCar");
	as.act();
	as.dance();
	as.sing();
	as.speaking();
	System.out.println(ActorSivakumar.address);
	Actor ac = new ActorSivakumar();
	ac.act();
	ac.dance();
	ac.sing();
	//ac.speaking();
	System.out.println(ac.address);
	}
	public void act()
	{
	System.out.println("I act only infront of camera");

	}
	public void dance()
	{
	System.out.println(" I am not a good dancer");
	}
	public void sing()
	{
	System.out.println("I am not a singer");
	}
	public void speaking()
	{
	System.out.println(" I am a very good spiritual speaker");
	}

	//Dynamic method is cant able to access own methods of child class
	//But dynamic method is possible to access parent class methods
}
