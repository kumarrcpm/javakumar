//First Hundred Number Average Calculator
package whileLoopBasicPrograms;

public class AvereageCalculator {
public static void main(String []args)
{
	int average;
	int total=0;
	int number=0;
	while(number<100)
	{
		total=total+number;
		number++;
	
	}
	System.out.println("Total "+total);
	average=(total/number);
	System.out.println("Average "+average);
}
}
