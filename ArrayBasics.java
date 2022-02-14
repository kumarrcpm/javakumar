package arrayBasics;

import java.util.Scanner;

public class ArrayBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ArrayBasics user = new ArrayBasics();
	//user.reportCard();
	//user.LowestFinder();
	user.biggestFinder();



	}
	public void biggestFinder()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total subjects");
		int count=sc.nextInt();
		int [] marks = new int[count];
		System.out.println("Enter your marks");
		for(int i=0;i<marks.length;i++)
		{
		marks[i]=sc.nextInt();
		}
		int big=0;
		int sbig=0;
		for(int i=0;i<marks.length;i++)
		{	
			int v=marks[i];
			if(v>big)
			{
				sbig=big;
				big=v;
			}
			else if(v>sbig)
			{
				sbig=v;
			}
		}
		System.out.println("biggest value "+big);
		System.out.println("Second biggest value "+sbig);
	}
	
	
	public void reportCard()
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of Subjects");
	int count= sc.nextInt();
	int total=0;
	int average = 0;
	int [] marks = new int [count];
	System.out.println("Enter Your Marks");
	for(int i=0;i<marks.length;i++)
	{
		marks[i]=sc.nextInt();
		total=total+marks[i];
	}
	for(int i=0;i<marks.length;i++)
	{
	System.out.println("Your Mark is "+marks[i]);
	}
	System.out.println("Total Marks is "+total);
	average=total/count;
	System.out.println("Average mark is "+average);
	
	}
}