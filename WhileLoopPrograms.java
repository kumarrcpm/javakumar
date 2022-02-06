///While Loop Numbers Programs
public class WhileLoopPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WhileLoopPrograms user = new WhileLoopPrograms();
//user.reverseNumber(12345);
//user.additionOfFirstFiveDigits(1);
//user.additionOfDigits(45678);
//user.countOfDigits(805694);
//user.palindrome(12321);
//user.additionOfDigitsUntilSingleDigit(805694);
//user.armstrongNumber(153);
//user.neonNumber(9);
//user.perfectNumber(6);
//user.findFactorial(5);
//user.strongNumber(145);
//user.fibonacci(0,1);
//user.fibonacciSeries(-1,1);
//user.primenumber(13);
//user.tables(8);
//user.gcd(16,24);
//user.lcd(15,25);
//user.lcm(13,29);
//user.swap(2,4);
//user.swapThree(2,4,6);
//user.spyNumber(1124);
//user.magicNumber(226);
	}


public void magicNumber(int input)
{
	int number=input;
	int total=0;
	int output=0;
	while(input>0)
	{
		int rem=input%10;
		input=input/10;
		total=total+rem;
		output=total;
	}
	System.out.println(total);
	
	if(total!=1)
		magicNumber(total);
	else if(output==1)
		System.out.println("Magic Number");
	else
		System.out.println("Not Magic Number");
	
}
	
public void spyNumber(int input)
{
	System.out.println("//////Spy Number///////////");
	int total=0;
	int multiple=1;
	while(input>0)
	{
		int rem=input%10;
		total=total+rem;
		multiple=multiple*rem;
		input=input/10;
	}
	System.out.println("Number addition is "+total);
	System.out.println("Number Multiplication is "+multiple);
	
	if (total==multiple)
		System.out.println("This is Spy Number");
	else
		System.out.println("Not Spy Number");
}
	
///////Swaping Three Numbers//////////////
	
public void swapThree(int a, int b, int c)
{
	System.out.println("////Swap Three Numbers////////");
	System.out.println("Before swap a is "+a);
	System.out.println("Before swap b is "+b);
	System.out.println("Before swap c is "+c);
	
	a=a+b+c;
	b=a-(b+c);
	c=a-(b+c);
	a=a-(b+c);
	
	System.out.println("After swap a is "+a);
	System.out.println("After swap b is "+b);
	System.out.println("After swap c is "+c);
}
	
//////Swaping Two Numbers////////////////
	
public void swap(int a,int b)
{
	System.out.println("//////Swap Two Numbers/////////");
	System.out.println("Before swap a is "+a);
	System.out.println("Before swap b is "+b);
	
	a=a+b;
	b=a-b;
	a=a-b;
	
	System.out.println("After swap a is "+a);
	System.out.println("After swap b is "+b);
}
	
/////Least Common Multiplier///////////
	
public void lcm(int a,int b)
{
	System.out.println("/////Least Common Multiplie///////");
	int big=a>b? a:b;
	while(true)
	{
	if(big%a==0 && big%b==0)
	{
		System.out.println("Least Common Multiple "+big);
		break;
	}
	big=big+1;
}
}
//////Least Common Divisor of Numbers////////	
public void lcd(int a,int b)
{
	System.out.println("//////// Least Common Divisor/////");
	int div=2;
	int count=0;
	int least=0;
	int small=a<b? a:b;
	while(small>div)
	{
		if((a%div==0) && (b%div==0))
			{
				System.out.println(div);
				least=div;
				count=count+1;
				if(count==1)
					break;
			}
		div=div+1;
	}
System.out.println("Least Common Divisor "+least);
}
	
	
//////Biggest Common Divisor of Numbers//////
public void gcd(int a,int b)
{
	System.out.println("////////Common Divisor//////");
	int small = a<b? a:b;
	int div=2;
	int biggest=0;
	while(small>div)
	{
		if((a%div==0) && (b%div==0))
		{
			System.out.println(div);
			biggest=div;
		}
		div=div+1;
	}
	System.out.println("Greatest Common Divisor "+biggest);

}
	
	
	
//////////Multiplication of a Given Number////////////
	
public void tables(int number)
{
	System.out.println("/// Tables /////");
	int i=1;
	while(i<=10)
	{
		int j=i*number;
		i++;
		System.out.println(j);
	}
}
	
//////Prime Number//////////
public void primenumber(int number)
{
	System.out.println("//////Prime Number//////////");
	int div=2;
	int count=0;
	while(number>div)
	{
	if(number%div==0)
	{
		System.out.println("Divisor "+div);
		count=count+1;
		System.out.println("No of Divisors "+count);
	}
	div=div+1;
	}
	if(count==0)
	System.out.println("Prime Number");
	else
		System.out.println("Non Prime Number");
	}

	
//////Fibonacci Series Without Third Variable/////

public void fibonacciSeries(int a,int b)
{
System.out.println("Fibonacci Series Without Third Variable");
int count=5;
while(count>0)
{
	b=a+b;
	a=b-a;
	count=count-1;
	System.out.println(b);
}
}

	
///////Fibonacci Series With  Third Variable//////////
	
public void fibonacci(int a,int b)
{
System.out.println("//////Fibonacci Series with Third Variable///////////");
int count=5;
while(count>0)
{
int c=a+b;
a=b;
b=c;
count=count-1;
System.out.println(c);

}
}
/////Strong Number//////////
public void strongNumber(int input)
{
	System.out.println("///////Strong Number//////////");
	int strong=input;
	int total=0;
	while(input>0)
	{	//int total=0;
		int rem=(input%10);
		int result =findFactorial(rem);
		input=input/10;
		total=total+result;
		System.out.println("Returned Factorial is "+total);
	}
	System.out.println("Final Output "+total);
if(strong==total)
	System.out.println("Strong Number");
else
	System.out.println("Not Strong Number");
}
	
//////Find Factorial ///////////
public int findFactorial(int rem)
{
	int fact=1;
	while(rem>0)
	{
		System.out.println(rem);
		fact=fact*rem;
		rem=rem-1;
		
	}
	System.out.println("Factorial Output is "+fact);
	return fact;
}
//////Perfect Number///////////
public void perfectNumber(int input)
{
	System.out.println("////////Perfect Number Program Ouput///////");
	int perfect=0;
	int i=1;
	while(input%i==0)
	{
		System.out.println(i);
		perfect=perfect+i;
		i++;
	}
	System.out.println("Perfect total is "+perfect);
	if(input==perfect)
		System.out.println("Perfect Number");
	else
		System.out.println("Not Perfect Number");
}
	
///////Neon Number/////////////
public void neonNumber(int input)
{
	System.out.println("/////////Neon Number Program Output/////");
	int total=0;
	int square=input*input;
	while(square>0)
	{
		int rem =(square%10);
		square=square/10;
		System.out.println(rem);
		total=total+rem;
	}
	System.out.println(total);
	if(input==total)
		System.out.println("This is Neon Number");
	else
		System.out.println("Not Neon Number");

}
	
	
//////Armstrong Number/////////
public void armstrongNumber(int input)
{
	System.out.println("/////////// Armstrong Number Program Output ///////////");
	int input1=input;
	int armstrong=0;
	while(input>0)
	{
		int rem=input%10;
		armstrong=armstrong+(rem*rem*rem);
		input=input/10;
		System.out.println(rem);
	}
	System.out.println("Armstrong Total is "+armstrong);
	if(input1==armstrong)
		System.out.println("This is Armstrong Number");
	else
		System.out.println("Not an Armstrong Number");
}
	
//////Addition of Digits Until Single Digit//////

public void additionOfDigitsUntilSingleDigit(int input)
{
	System.out.println("//////// Addition of Digits Until Single Digit  Program Output/////////");
	int total=0;
	while(input>0)
	{
		int rem =(input%10);
		total=total+rem;
		input=input/10;
		System.out.println(rem);
	}
	System.out.println("Final output is "+total);
	if(total>9)
		additionOfDigitsUntilSingleDigit(total);
}
	
////////Palindrome/////////
	
public void palindrome(int input)
{
System.out.println("////// Palindrome Program Output ////////////");
int input1=input;
int reverse=0;
while(input>0)
{
	int rem=input%10;
	input=input/10;
	reverse=(reverse*10)+rem;
	System.out.println(reverse);
}
	if (input1==reverse)
		System.out.println("Palindrome");
	else
		System.out.println("Not Palindrome");
}

////// Count of Given Numbers//////////
	
	public void countOfDigits(int input)
	{
		System.out.println("///// Count Total Number of Digits in input /////////");
		int count=0;
		while(input>0)
		{
			int rem=input%10;
			input=input/10;
			count=count+1;
			System.out.println(rem);
		}
		System.out.println("Total Number of Digits "+count);
	}
	
//////////Addition of Given Numbers///////////
	public void additionOfDigits(int input)
	{
		System.out.println("///// Addition of Digits /////////");
		int total=0;
		while(input>0)
		{
			int rem=input%10;
			total=total+rem;
			input=input/10;
			System.out.println(rem);
		}
		System.out.println("Final Total is "+total);
	}
//////////Addition of First Five Digits/////////////
	public void additionOfFirstFiveDigits(int input)
	{
	System.out.println("/////// Addition of First Five Digits////////");
		int total=0;
		while(true)
		{
			total=total+input;
			input=input+1;
			System.out.println(total);
			if(input==6)
				break;
		}
		System.out.println("Final Total is "+total);
	}
	
	///////Reverse Number Program//////
public void reverseNumber(int input)
{
	System.out.println("///// Reverse a Given Number Program Output////////");
	int reverse=0;
while (input>0)
{
	int rem=(input%10);
	input=input/10;
	reverse=(reverse*10)+rem;
	System.out.println(rem);
}
System.out.println("Number in Reverse "+reverse);
}
}
