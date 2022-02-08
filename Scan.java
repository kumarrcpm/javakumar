package scan;
import java.util.Scanner;
public class Scan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Scan user = new Scan();
//user.addInt();
//user.addFloat();
//user.addboolean();
//user.next();
user.line();
user.adddouble();
user.addlong();

	}
	
public void addlong()

{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter values");
	long a = sc.nextLong();
	long b = sc.nextLong();
	long c = a+b;
	System.out.println(c);
	
}
	
public void adddouble()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter values");
	double a = sc.nextDouble();
	double b = sc.nextDouble();
	double c = (a+b);
	System.out.println(c);
}
	
public void line()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Values");
	String a =sc.nextLine();
	String b =sc.nextLine();
	System.out.println(a);
	System.out.println(b);
	String c =a+b;
	System.out.println(c);
}
	
public void next()

{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter values");
	String a= sc.next();
	String b= sc.next();
	System.out.println(a);
	System.out.println(b);
	String c = a+b;
	System.out.println(c);
}
	
public void addboolean()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter values");
	boolean a = sc.nextBoolean();
	boolean b = sc.nextBoolean();
	System.out.println(a);
	System.out.println(b);
	//boolean c =(boolean a , boolean b);
	//System.out.println(c);
}
public void addFloat()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Numbers");
	float a = sc.nextFloat();
	float b = sc.nextFloat();
	System.out.println(a);
	System.out.println(b);
	float c =a+b;
	System.out.println(c);
}
	
	
	
public void addInt() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Numbers");
	int a =sc.nextInt();
	int b =sc.nextInt();
	System.out.println(a);
	System.out.println(b);
	int c =a+b;
	System.out.println(c);
}

}