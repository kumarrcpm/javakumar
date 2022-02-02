package numbersProgram;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 371;
		int number1 = number;
		int total = 0;
		while (number > 0) {
			int rem = (number % 10);
			number = number / 10;
			total = total + (rem * rem * rem);
			System.out.println(total);

		}
		System.out.println(total);
		if (number1 == total) {
			System.out.println("Given Number is Armstrong");
		} else {
			System.out.println("Not an Armstrong Number");
		}
	}

}
