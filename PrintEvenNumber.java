//Print First Five Even Numbers and Calculate total Value of First Five Even Numbers
package whileLoopBasicPrograms;

public class PrintEvenNumber {
	public static void main(String [] args)
	{
	int count=2;
	int total=0;
	while(count<=10)
	{
		System.out.println("Even Number "+count);
		total=total+count;
		count=count+2;
	}
	System.out.println("Even Number Total value is "+total);
	}
}
