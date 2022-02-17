package arrayBasics;

import java.util.Scanner;

public class ArrayBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	ArrayBasics user = new ArrayBasics();
	//user.reportCard();
	//user.LowestFinder();
	//user.biggestFinder();
	//user.linearSearch();
	//user.binarySearch();


	}

	private void binarySearch() {
		// TODO Auto-generated method stub
		int[] num = {2,3,5,6,1,77,67,93};
		int key=2;
		int min=0;
		int max=num.length-1;
		while(min<=max)
		{
		int mid= (min+max)/2;
			if(key==num[mid])
			{
				System.out.println("number is present");
				break;
			}
			else if(key>num[mid])
			{
				max=mid-1;
			}
			else if(key<num[mid])
			{
				min=mid+1;
			}
		}
		if(min>max) {
			System.out.println("Your number is not present");
		}
		
	}

	public void linearSearch()
	{
		int[] num= {55,47,65,24,76};
		int key=44;
		int i=0;
		for(i=0;i<num.length;i++)
		{
		if(num[i]==key)
		{
			System.out.println("Number is present");
		break;
		}
		else if(i>num.length)
		{
		System.out.println("Number is not present");
	}
	}	
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