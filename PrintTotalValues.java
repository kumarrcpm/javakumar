//Addition of first five numbers

package whileLoopBasicPrograms;

public class PrintTotalValues {
public static void main(String [] args)
{
int count =0;
int total=0;
while (count<5)
{
	System.out.println("Number is "+count);
	total=total+count;
	count=count+1;
	System.out.println("Total = "+total);
}
System.out.println("Addition of first number total is "+total);
}
}
