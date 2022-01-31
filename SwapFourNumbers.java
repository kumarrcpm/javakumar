package swappingNumbersProgram;

public class SwapFourNumbers {
public static void main(String [] args)
{
	int a=23,b=41,c=16,d=34;
	System.out.println("Before swap a value is "+a);
	System.out.println("Before swap b value is "+b);
	System.out.println("Before swap c value is "+c);
	System.out.println("Before swap d value is "+d);
	a=a+b+c+d;
	System.out.println("After add a value is "+a);
	
	c=a-(b+c+d);
	b=a-(b+c+d);
	d=a-(b+c+d);
	a=a-(b+c+d);
	
	System.out.println("After swap a value is "+a);
	System.out.println("After swap b value is "+b);
	System.out.println("After swap c value is "+c);
	System.out.println("After swap d value is "+d);
	
}
	
}
