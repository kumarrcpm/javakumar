//Balance Calculator
package whileLoopBasicPrograms;

public class BalanceCalculator {
public static void main(String []args)
{
	int total=100;
	int count=0;
	while(count<5)
	{
		System.out.println(count);
		total=total-count;
		count++;
	}
	System.out.println("Balance "+total);
}
}
