package swappingNumbersProgram;

public class FiveNumberSwap {
public static void main(String [] args)
{
	int a=19,b=27,c=35,d=8,e=45;
	
	System.out.println("Before swap a value is "+a);
	System.out.println("Before swap b value is "+b);
	System.out.println("Before swap c value is "+c);
	System.out.println("Before swap d value is "+d);
	System.out.println("Before swap e value is "+e);
	
	a=a+b+c+d+e;
	System.out.println("After add a value is "+a);
	
	c=a-(b+c+d+e);
	e=a-(b+c+d+e);
	b=a-(b+c+d+e);
	d=a-(b+c+d+e);
	a=a-(b+c+d+e);
	
	System.out.println("After swap a value is "+a);
	System.out.println("After swap b value is "+b);
	System.out.println("After swap c value is "+c);
	System.out.println("After swap d value is "+d);
	System.out.println("After swap e value is "+e);
}
}
