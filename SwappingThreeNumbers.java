//Swapping Three Numbers Without Fourth Variable
package swappingNumbersProgram;

public class SwappingThreeNumbers {
public static void main(String [] args)
{
	int a=5,b=10,c=15;
	System.out.println("Before Swap a is "+a);
	System.out.println("Before Swap b is "+b);
	System.out.println("Before Swap c is "+c);
	a=a+b+c;
	System.out.println(a);
	c=a-(b+c);
	b=a-(b+c);
	a=a-(b+c);
	System.out.println("After Swap a is "+a);
	System.out.println("After Swap b is "+b);
	System.out.println("After Swap c is "+c);
	
	
}
}
