//Reverse First Five Even Numbers
package whileLoopBasicPrograms;

public class ReverseFirstFiveEvenNumber {
	public static void main(String [] args)
	{
		int count=10;
		int total=0;
		while (count>0)
		{
			total=total+count;
			System.out.println(count);
			count=count-2;
		}
		System.out.println(total);
	}
	

}
