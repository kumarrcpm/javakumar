//Reverse First five odd Number
package whileLoopBasicPrograms;

public class ReverseFirstFiveOddNumber {

	public static void main(String [] args)
	{
		int count=9;
		int total=0;
		while(count>0)
		{
			total=total+count;
			System.out.println(count);
			count=count-2;
		}
		System.out.println(total);
	}
}
