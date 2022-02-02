package numbersProgram;

public class NeonNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int neon = 9;
		int number = neon;
		int total = 0;
		int value = neon * neon;
		System.out.println(value);
		while (value > 0) {
			int value1 = (value % 10);
			value = value / 10;
			total = total + value1;
		}
		System.out.println(total);
		if (number == total) {
			System.out.println("Given number is neon number");

		} else {
			System.out.println("Not neon number");
		}
	}

}
