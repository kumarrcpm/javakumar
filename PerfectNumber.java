package numbersProgram;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int num = 6;
		int number=0;
		while (num % i == 0) {
			number=number+i;
			System.out.println(i);
			i = i + 1;
		}
		System.out.println(number);
if(number==num)
{
	System.out.println("This is perfect number");
}
else
{
	System.out.println("Not a perfect number");
}
	}

}
