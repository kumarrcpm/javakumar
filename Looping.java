
public class Looping {
public static void main(String [] args)
{
	Looping user = new Looping();
	//user.whileLoop(2,5);
	user.doWhileLoop(2,5);
}

public void whileLoop(int a,int b)
{
	while(b>a)
	{
		int c=a+b;
		System.out.println(c);
		break;
	}
}

public void doWhileLoop(int a, int b)
{
	do
	{
		int c=a+b;
		System.out.println(c);
	}while(a>b);
}
}
