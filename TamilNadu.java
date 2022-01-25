
public class TamilNadu extends SouthIndia {
	static String capital = "Chennai";
	public static void main(String [] args)
	{
	SouthIndia si = new TamilNadu();
	si.speaklanguage();
	si.eat();     //Using si object we can access parent abstract methods
	si.dress();   //sub abstract methods but if that method is override child class is get output
	si.cultivate();
	si.livingStyle();
	System.out.println(India.capital);
	System.out.println(TamilNadu.capital);

	}
	public void speaklanguage()
	{
	System.out.println("Tamil is the official language");
	}
	public void eat()
	{
	System.out.println("Rice items are main food");
	}
	public void dress()
	{
	System.out.println("Dhoti and sarees are traditional dress");
	}
	public void cultivate()
	{
	System.out.println("Rice and sugarcane cultivation");
	}
	public void livingStyle()
	{
	System.out.println("Above average development");
	}
}
