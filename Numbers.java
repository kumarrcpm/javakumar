package whileLoopBasicPrograms;

public class Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numbers user = new Numbers();
		// user.strongNumber(145);
		// user.neonNumber(9);
		// user.additionOfdigits(805694);
		//user.fibonacciSeries(5);
		//user.findDivisor(100);
		//user.commonDivisor(100,50);
		user.findCommonMultiple(3,9);
	}
	//////LCM///
private void findCommonMultiple(int no1, int no2) {
		// TODO Auto-generated method stub
		int big=no1>no2? no1:no2;
		while(true)
		{
		if(big%no1==0 && big%no2==0)
		{
			System.out.println("LCM "+big);
			break;
		}
		big=big+1;
		
	}
}
//////Common Dvisior  GCD
private void commonDivisor(int no1, int no2) {
		// TODO Auto-generated method stub
		int small = no1<no2? no1:no2;
		int div=2;
		int biggest=0;
		while(div<=small) {
			if(no1%div==0 && no2%div==0)
			{
				//System.out.println(div);
				biggest=div;
			}
			div=div+1;
		}
		System.out.println(biggest);
	}
///////////Prime Number//////////
private void findDivisor(int no) {
		// TODO Auto-generated method stub
		int div=2;
		int count=0;
		while(div<no)
		{
			if(no%div==0)
			{
				System.out.println(div);
				count=count+1;
			}
			div=div+1;
		}
		System.out.println("No of Divisors "+count);
		if (count==0)
			System.out.println("Prime Number");
		else
			System.out.println("Not Prime");
	}

	///////////Fibonacci Series/////////////////////
	private void fibonacciSeries(int count) {

		int a = -1, b = 1;
		while (count > 0) {
			System.out.println(a + b);

			b = a + b;
			a = b - a;
			count = count - 1;

		}

	}

	//////////// Addition of Digits///////////
	private void additionOfdigits(int input) {
		// TODO Auto-generated method stub
		int number = input;
		int addition = 0;
		while (input > 0) {
			int rem = (input % 10);
			addition = addition + rem;
			input = input / 10;
		}
		System.out.println(addition);
		if (addition > 9)
			additionOfdigits(addition);

	}

	/////////// Neon Number///////////////////
	public void neonNumber(int input) {
		int output = square(input);
		int input1 = input;
		{
			int total = 0;
			while (output > 0) {
				int rem = output % 10;
				total = total + rem;
				output = output / 10;
			}
			System.out.println(total);
			if (input1 == total)
				System.out.println("Neon Number");
			else
				System.out.println("Not NeonNumber");
		}

	}

	public int square(int input) {
		int square = input * input;
		return square;
	}

//////////Strong Number//////////////////////////
	public void strongNumber(int input) {
		int number = input;
		int total = 0;
		while (input > 0) {
			int rem = (input % 10);
			int result = findFactorial(rem);
			input = input / 10;
			total = total + result;
			System.out.println(total);
		}
		if (number == total)
			System.out.println("strong number");
		else
			System.out.println("Not a strong Number");

	}

	static int findFactorial(int no) {
		int fact = 1;
		while (no > 0) {

			fact = fact * no;
			no = no - 1;
		}
		return fact;
	}

}