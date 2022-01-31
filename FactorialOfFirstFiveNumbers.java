//Factorial of first five even numbers
package whileLoopBasicPrograms;

public class FactorialOfFirstFiveNumbers {
public static void main(String[] args)
{
	int count=1;
	int total=1;
	while(count<=5)
	{
		total=total*count;
		System.out.println(count);
		count++;
	}
System.out.println(total);
}

}
