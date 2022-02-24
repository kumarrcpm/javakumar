package exceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionDemo {
	public static void main(String[] args)  {
		ExceptionDemo user = new ExceptionDemo();
		//user.example();
		user.example2();
		//user.example3();
	}
	public void example3() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Numbers");
		int a=0,b=0;
		a=sc.nextInt();
		b=sc.nextInt();
		int [] c =  new int[a+b];
		System.out.println(a/b);
	}
	private void example2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Numbers");
		int a=0,b=0;
		try
		{
			a=sc.nextInt();
			b=sc.nextInt();
			int [] c =  new int[a+b];
			System.out.println(a/b);
		}
		catch(ArithmeticException ab)
		{
			System.out.println("Check input");
		}
		catch(InputMismatchException ab)
		{
			System.out.println("Check input");
		}
		catch(Exception ab)
		{
			System.out.println("Something went Wrong");
		}
	}

	private void example() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Numbers");
		int a=0,b=0;
		try
		{
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(a+b);
		System.out.println(a/b);

		}
		catch(InputMismatchException | ArithmeticException ab)
		{
			String reason = ab.getMessage();
			System.out.println(reason);
			System.out.println("Check input");
		}
		finally
		{
			System.out.println("Finally is Working");
		}
	}

}
