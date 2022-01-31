//Print First Five Odd Numbers and calculate total value of First Five Odd numbers
package whileLoopBasicPrograms;

public class PrintOddNumber {
	public static void main (String [] args)
	{
		int count =1;
		int total=0;
		while(count<10)
		{
			System.out.println("Odd Number "+count);
			total=total+count;
			System.out.println("Total value "+total);
			count=count+2;
		}
		System.out.println("Final Total Odd value is "+total);
	}

}
