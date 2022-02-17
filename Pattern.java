package patternPrograms;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Pattern user = new Pattern();
//user.pattern1();
//user.pattern2();
//user.pattern3();
//user.pattern4();
//user.pattern5();
//user.pattern6();
//user.pattern7();
//user.pattern8();
//user.pattern9();
user.pattern10();
	}
	
public void pattern10()
{
	for (int row=5;row>=1;row--)
	{
		for(int col=1;col<row;col++)
		{
			System.out.print(" "+ " ");
			
		}
		for (int star =1;star<=6-row;star++)
		{
			System.out.print(" "+row+" ");
		}
		System.out.println();
	}
}
public void pattern9()
{
	for(int r=5;r>=1;r--)
	{
		for(int col=1;col<=r;col++)
		{
			System.out.print((col*r)+ " ");
			
		}
		System.out.println();
	}
}
public void pattern8()
{
	for(int row=1;row<=4;row++)
	{
		for(int col=1;col<=5;col++)
		{
			System.out.print("*"+ " ");
		}
		System.out.println();
	}
}
public void pattern7()
{
	for(int row=1;row<=3;row++)
	{
		for(int col=5;col>=1;col--)
		{
			System.out.print(col + " ");
		}
		System.out.println();
	}
}
	
public void pattern6()
{
	for(int row=3;row>=1;row--)
	{
		for(int col=1;col<=5;col++)
		{
			System.out.print(row+" ");
		}
		System.out.println();
	}
}
	
public void pattern5()
{
	for(int row=1;row<=3;row++)
	{
	for (int col=1;col<=5;col++)
	{
		System.out.print(row+" ");
	}
	System.out.println();
	}
}
	
public void pattern4()
{
	for(int row=1;row<=3;row++)
	{
	for (int col=1;col<=5;col++)
	{
		System.out.print(col+" ");
	}
	System.out.println();
	}
}
	
public void pattern3()
{
	for(int row=1;row<=3;row++)
	{
	for (int col=1;col<=5;col++)
	{
		System.out.print(1+" ");
	}
	System.out.println();
	}
}
	
public void pattern2()
{
	for(int col=1;col<=5;col++)
	{
		System.out.print(1+" ");
	}
	System.out.println();
	for(int col=1;col<=5;col++)
	{
		System.out.print(1+" ");
	}
	System.out.println();
	for(int col=1;col<=5;col++)
	{
		System.out.print(1+" ");
	}
	System.out.println();
}
	
public void pattern1()
{
for(int col=1;col<=5;col++)
{
	System.out.print(1+ " ");
}
}
}









