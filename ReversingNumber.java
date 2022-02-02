package whileLoopBasicPrograms;

public class ReversingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int box=12321;
		int box1=box;
		int reverse=0;
		while(box>0)
		{
			int rem=box%10;
			box=box/10;
			reverse=(reverse*10)+rem;
		}
		System.out.println(reverse);
	if (box1==reverse)
	{
		System.out.println("palindrome");
	}
	else
	{
		System.out.println("Not palindrome");
		
	}
	}

}
