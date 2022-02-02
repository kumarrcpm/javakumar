package numbersProgram;
public class StrongNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 145;
		int number1 = number;
		int value = 0;
		while (number > 0) {
			int rem = (number % 10);
			number = number / 10;
			int total = 1;
			System.out.println(rem);
			while (1 <= rem) {
				total = total * rem;
				rem--;
			}
			value = total + value;
			System.out.println(value);
		}
		if (number1 == value) {
			System.out.println("Given number is strong number");
		} else

		{
			System.out.println("Given number is not strong number");
		}
	}

}
