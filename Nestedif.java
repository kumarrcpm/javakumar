//Nested if comparing three numbers
public class Nestedif 
{
public static void main(String [] args)
{
int a=5, b=10, c=15;
if(a>b)
	{
		if (a>c)
			{
				System.out.println("A is greater");
			}
		else if (c>a)
			{
				System.out.println("C is greater");
			}
		else
			{
				System.out.println("A and C both are equal");
			}
	}
else if(b>a)
	{
		if(b>c)
		
			{
				System.out.println("B is greater");
			}
			else if (c>b)
			{
				System.out.println("c is greater");
			}
			else
			{
				System.out.println("B and c are equal");
			}
		
	}	
	
else if (a>b)  //Compare A or C with B
	
		{
			System.out.println("A and C is equal.A and C is greater than B");
		}
		else if (c>a)
			{
				System.out.println("C is greater");
			}
		else 
			{
				System.out.println("A B C all are equal");
			}
	


}
}