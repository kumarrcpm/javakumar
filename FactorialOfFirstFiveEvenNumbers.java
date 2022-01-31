//Factorial of first five even numbers
package whileLoopBasicPrograms;

public class FactorialOfFirstFiveEvenNumbers {
	public static void main(String [] args)
	{
		int count=2;
		int total=1;
		while(count<=10)
		{
			total=total*count;
			System.out.println(count);
			count=count+2;
		}
	System.out.println(total);
	}
	

}
