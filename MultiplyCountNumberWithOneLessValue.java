//Multiply count value with one less count
package whileLoopBasicPrograms;

public class MultiplyCountNumberWithOneLessValue {
public static void main(String[] args)
{
	int count=1;
	int total=0;
	while(count<5)
	{
		System.out.println(count*(count-1));
		total=total+count;
		count++;
	}
	System.out.println(total);
}
}
