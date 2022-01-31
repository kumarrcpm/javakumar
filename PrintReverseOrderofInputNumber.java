//Print Reverse order of input numbers
package whileLoopBasicPrograms;

public class PrintReverseOrderofInputNumber {

	public static void main(String[] args)
	{
		int input=805694;
		while(input>0)
		{		
			System.out.println(input%10);
			input=input/10;
		}
	}
	
}
