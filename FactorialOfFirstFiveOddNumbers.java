//Factorial of first five odd numbers
package whileLoopBasicPrograms;

public class FactorialOfFirstFiveOddNumbers {
	public static void main(String [] args)
	{
		int count=1;
		int total=1;
		while(count<10)
		{
			total=total*count;
			System.out.println(count);
			count=count+2;
			
		}
		System.out.println(total);
	}

}
