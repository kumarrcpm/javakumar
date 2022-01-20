//Nested if comparing four numbers
public class Nestedif1 
{
public static void main(String [] args)
{
int a=3, b=20, c=5, d=10;
if (a>b)
{
	if (a>c)
		{
			if (a>d)
				{
					System.out.println("A is greater");
				}
			else if (d>a)
				{
					System.out.println("D is greater");
				}
			else
				{
					System.out.println("A and D is equal");
				}
		}
	else if (c>a)
		{
			if(c>d)
				{
					System.out.println("C is greater");
				}
			else if (d>c)
				{
					System.out.println("D is greater");
				}
			else
				{
					System.out.println("D and C is equal");
				}
		}
	else
		{
			System.out.println("C and A is equal");
		}
}
else if(b>a)
	{
		if(b>c)
			{
				if (b>d)
					{	
						System.out.println("B is greater");
					}
				else if (d>b)
					{
						System.out.println("D is greater");
					}
				else
					{
						System.out.println("D and B are equal");
					}
			}
		else if (c>b)
			{
				System.out.println("C is greater");
			}
		else
			{
				System.out.println("B and C are equal");
			}
	}
	else if (a>c)  // else if (a,b>c) a and b are equal and compare with c
		{
			System.out.println(" A and B is equal, greater than C");
		}	
		else if(c>a) // else if (c>a,b) a and b are equal and compare with c
			{
				System.out.println("C is greater than A and B, A and B are equal");
			}
			 	if (a>d) // if (a,b,c>d) a,b,c are equal and compare with d
					{
						System.out.println("A,B,C are equal and greater than D");
					}
				else if (d>c) //else if (d>a,b,c) a,b,c are equal and compare with d
					{
						System.out.println("D is greater than A,B,C");
					}
				else
					{
						System.out.println("All are equal");
					}
	}

}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		