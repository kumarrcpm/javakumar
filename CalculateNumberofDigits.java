//Calculate Number of Digits of Given Input number
package whileLoopBasicPrograms;

public class CalculateNumberofDigits {
	public static void main(String[]args)
	{
		int input = 989492;
		int count=0;
		int add=0;
		while(input>0)
		{
			System.out.println(input%10);
			int rem=input%10;
			input=input/10;
			count=count+1;
			add=add+rem;
		}
		System.out.println("Total No of Digits in input "+count);
		System.out.println("Addition of Total Values "+add);
	}

}
