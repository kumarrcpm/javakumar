
public class Samsung extends FactoryDemo {
	static int price = 5000;
	public static void main(String [] args)
	{

	Samsung sam = new Samsung();
	sam.browse();  //browse method is calling abstract sub class method and abstract class constructor
	System.out.println(sam.price); //5000 is print
	}
	public int call(int seconds)
	{
	System.out.println("Parent abstract class");
	return seconds;
	}
	public void sendMessage()
	{
	System.out.println("Parent abstract class");
	}
	public void receivecall()
	{
	System.out.println("Parent abstract class");
	}
	public void verifyFingerPrint()
	{
	System.out.println(" Abstract sub class");
	}
	public void providePattern()
	{
	System.out.println("Abstract sub class");
	}
}
