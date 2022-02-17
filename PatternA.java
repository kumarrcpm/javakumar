package patternPrograms;

public class PatternA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
PatternA user= new PatternA();
//user.pattern();
//user.pattern1();
//user.pattern2();
//user.pattern3();
//user.pattern4();
//user.pattern5();
//user.pattern6();
//user.pattern7();
//user.pattern8();
//user.pattern9();
//user.pattern10();
//user.pattern11();
//user.pattern12();
//user.pattern13();
//user.pattern14();
//user.pattern15();
//user.pattern16();
//user.pattern17();
//user.pattern18();
//user.pattern19();
//user.pattern20();
//user.pattern21();
//user.pattern22();
//user.pattern23();
//user.pattern24();
//user.pattern25();
//user.pattern26();
//user.pattern27();
//user.pattern28();
//user.pattern29();
//user.pattern30();
//user.pattern31();
//user.pattern32();
user.pattern33();
	}
	


private void pattern33() {
		// TODO Auto-generated method stub
		for(int row=1;row<=5;row++)
		{
			for(int col=1;col<=row;col++)
			{
				System.out.print(col);
			}
				for(int a=row-1;a>=1;a--)
				{
					System.out.print(a);
			}
				System.out.println();
		}
	}



public void pattern32()
{
		int i=2;
		String a = "*";
		String b = "!";
		for(int row=1;row<=8;row++)
		{
		for(int col=1;col<=8;col++)
		{	
			if(i%2==0)
			System.out.print(a+" ");
			else
			System.out.print(b+" ");
			i++;
			
		}
		String temp =a;
		a=b;
		b=temp;
		System.out.println();
		}
}

	
public void pattern31()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row-1;col++)
		{
			System.out.print(" ");
		}
		int i=5;
		for(int col1=5;col1>=row;col1--)
		{
			System.out.print(i+" ");
			i--;
		}
		System.out.println();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public void pattern30()
{
	for(int row=1;row<=5;row++)
	{
		for(int col1=5;col1>row;col1--)
		{
			System.out.print(" ");
		}
		for(int col2=1;col2<=row;col2++)
		{
			System.out.print(1);
		}
		System.out.println();
	}
}
	
public void pattern29()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<row;col++)
		{
			System.out.print(" ");
		}
		for(int star=5; star>=row; star--)
		{
			System.out.print(1);
		}
		System.out.println();
	}
}
	
public void pattern28()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=5;col>row;col--)
		{
			System.out.print(" "+" ");
		}
				for(int star=1;star<=row;star++)
			{
				System.out.print("*"+" ");
			}
			System.out.println();
	}
}
	
public void pattern27()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col--)
		{
			System.out.print(1+" ");
			for(int star=1;star<=6-col;star++)
			{
				System.out.print("*"+" ");
			}
		}
	}
}
	
public void pattern26()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=5;col>=row;col--)
		{
			System.out.print(col);
		}
		System.out.println();
	}
}
	
public void pattern25()
{
	for(int row=1;row<=5;row++)
	{
		int i=1;
		for(int col=5;col>=row;col--)
		{
			System.out.print(i);
			i++;
		}
		System.out.println();
	}
}
public void pattern24()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=5;col>=row;col--)
		{
			System.out.print(1);
		}
		System.out.println();
	}
}
	
public void pattern23()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(row);
		}
		System.out.println();
	}
}
	
public void pattern22()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(col);
		}
		System.out.println();
	}
}
	
public void pattern21()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(1);
		}
		System.out.println();
	}
}
	
	private void pattern10() {
		// TODO Auto-generated method stub
	for(int star=1;star<=9;star++)
		{
		if(star==1 || star==9)
		{
			System.out.print("  "); 
		}
		else
			System.out.print("* "); 
		}
		System.out.println();
	for(int row=1; row<=9;row++)
	{
		for(int star=1;star<=9;star++)
		{
			if(star==9)
			System.out.print("* "); 
			else
				System.out.print("  "); 
		}
		System.out.println(); 
	}
	for(int star=1;star<=9;star++)
	{
	if(star==1 || star==9)
	{
		System.out.print("  "); 
	}
	else
		System.out.print("* "); 
	}
	System.out.println();
	for(int row=1; row<=9;row++)
	{
		for(int star=1;star<=9;star++)
		{
			if(star==1)
			System.out.print("* "); 
			else
				System.out.print("  "); 
		}
		System.out.println(); 
	}
		
	}	
public void pattern20()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<row;col++)
		{
			System.out.print(" "+" ");
		}
		for(int hash=1;hash<=6-row;hash++)
		{
			System.out.print(hash+" ");
		}	
			System.out.println();
	}
}
	
public void pattern19()
{
	int i=1;
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(i+" ");
			i++;
		}
		System.out.println();
	}
}
	
public void pattern18()

{
	for(int row=1;row<=5;row++)
	{
		int i=0;
		for(int col=1;col<=row;col++)
		{
			System.out.print(i*row+" ");
			i++;
		}
		System.out.println();
	}
}
	
public void pattern17()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(col);
		}
		System.out.println();
	}
}
	
	
	
	
public void pattern16()
{
	int i=1;
	for(int row=1;row<=5;row++)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(i);
		}
		i+=2;
		System.out.println();
	}
}
	
	
	
	
	
	
	
	public void pattern15()
	{
		for(int row=5;row>=1;row--)
		{
			for(int col=2;col<=row;col++)
			{
				System.out.print(" "+" ");
			}
			int i=5;
			for(int star=1;star<=6-row;star++)
			{
				System.out.print(" "+i+"  ");
				i--;
			}
			System.out.println();
		}
	}	
	
	public void pattern14()
	{
		int i=1;
		for(int row=5;row>=1;row--)
		{
			for(int col=2;col<=row;col++)
			{
				System.out.print(" "+" ");
			}
			for(int star=1;star<=6-row;star++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
			i++;
		}
	}	
	
	public void pattern13()
	{
		for(int row=5;row>=1;row--)
		{
			for(int col=2;col<=row;col++)
			{
				System.out.print(" "+" ");
			}
			int i=5;
			for(int star=1;star<=6-row;star++)
			{
				System.out.print(i+" ");
				i--;
			}
			System.out.println();
		}
	}
	
	
public void pattern12()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=2;col<=row;col++)
		{
			System.out.print(" "+" ");
		}
		int i=1;
		for(int star=1;star<=6-row;star++)
		{
			System.out.print(i+" ");
			i++;
		}
		System.out.println();
	}
}
	
public void pattern11()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(" "+" ");
		}
		for(int star=1;star<=6-row;star++)
		{
			System.out.print("*"+" ");
		}
		System.out.println();
	}
}
	
public void pattern()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(col);
		}
		for(int star=1;star<=5;star++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
}
	
public void pattern9()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print(col+" ");
		}
		System.out.print("*");
		System.out.println();
	}
}

public void pattern8()
{
	for(int row=5;row>=1;row--)
	{
		int i=5;
		for(int col=1;col<=row;col++)
		{
			System.out.print(i+ " ");
			i--;
		}
		System.out.println();
	}
}
	
public void pattern7()
{
	int i =1;
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print((col*i)+ " ");
		}
		i++;
		System.out.println();
	}
}
	
public void pattern6()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print((row*col)+" ");
		}
		System.out.println();
	}
}
	
public void pattern5()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print((row*col)+" ");
		}
		System.out.println();
	}
}
	
public void pattern4()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print((col*5)+" ");
		}
		System.out.println();
	}
}
	
public void pattern3()
{
	for(int row=5;row>=1;row--)
	{
		for(int col=1;col<=row;col++)
		{
			System.out.print((col*2)+ " ");
		}
		System.out.println();
	}
}
	
public void pattern2()
{
	for(int row=1;row<=5;row++)
	{
		for(int col=5;col>=row;col--)
		{
			System.out.print(row+" ");
		}
		System.out.println();
	}
}
	
	
public void pattern1()
{
	for(int row=1;row<=5;row++)
	{
	for(int col=5;col>=row;col--)
	{
		System.out.print(1+ " ");
	}
	System.out.println();
	}
}
	
}
