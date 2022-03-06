package forLoopBasicPrograms;
import java.util.Scanner;
public class ForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ForLoop user = new ForLoop();
//user.reverse(12345);
//user.countofDigits();
//user.additionofDigits();
//user.palindrome();
//user.armstrong();
//user.neon();
//user.perfect();
//user.strong();
//user.factorial(5);
//System.out.println(result);
	}

public void strong()
{
	
}

public int factorial(int rem)
{
	int total=0;
	for(int fact=1;rem>0;rem--)
	{
		int result=0;
		fact=fact*rem;
	//	System.out.println(fact);
		result=result+fact;
		total=result;
	System.out.println(total);
	}
	return total;
}
public void perfect()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter values");
	int i=1;
	int total=0;
	for(int a= sc.nextInt();a%i==0;i++)
	{
		System.out.println(i);
		total=total+i;
	}
	System.out.println(total);
	//if(a==total)
		//System.out.println("Perfect Number");
	//else
		//System.out.println("Not Perect Number");
}

	
public void neon()
{
	while(true)
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Values");
	int a=sc.nextInt();
	if(a==0)
	break;
	
	int total=0;
	for(int square=a*a;square>0;square=square/10)
	{
		int rem=square%10;
		System.out.println(rem);
		total=total+rem;
	}
	System.out.println(total);
	if(a==total)
		System.out.println("Neon Number");
	else
		System.out.println("No Neon Number");
	}
	}
public void armstrong()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Values");
	int a =sc.nextInt();
	int b=a;
	int total=0;
	for(int input=a;input>0;input=input/10)
	{
		int cube=0;
		int rem=input%10;
		cube=cube+(rem*rem*rem);
		total=total+cube;
	}
	System.out.println(total);
	if(b==total)
		System.out.println("Armstrong");
	else
		System.out.println("Not Armstrong");
}
public void palindrome()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Values");
	int a=sc.nextInt();
	int reverse=0;
	int b=a;
	for(int input=a;input>0;input=input/10)
	{
		int rem=input%10;
		reverse=(reverse*10)+rem;
	}
	System.out.println("Output "+reverse);
	if(b==reverse)
		System.out.println("Palindrome");
	else
		System.out.println("Not Palindrome");
}
	
public void additionofDigits()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Values");
	int a = sc.nextInt();
	int total=0;
	for(int input=a;input>0;input=input/10)
	{
		int rem=input%10;
		total=total+rem;
	}
	System.out.println("Addition value is "+total);
}
	
public void countofDigits()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Values");
	int a =sc.nextInt();
	int count=0;
	for(int input=a;input>0;input=input/10)
	{
		int rem=input%10;
		count =count+1;
	}
	System.out.println(count);
}
public void reverse(int input)
{
	int reverse=0;
	for(input=12345;input>0;input=input/10)
	{
		int rem=input%10;
		reverse=(reverse*10)+rem;
	}
	System.out.println(reverse);
}
}
