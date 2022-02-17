package arr;
import java.util.Scanner;
public class arr {

	public static void main(String[] args) {
	arr user= new arr();
	//user.secondBig();
	//user.sortArray();
	//user.linearSearch();
	//user.binarySearch();
	//user.twoDimension();
	//user.arraylength();
	//user.arrayAddition();
	user.transposeMatrix();
	}
	
	public void transposeMatrix()
	{
		int[][] a = {{10,20,30},{40,50,60},{70,80,90}};
		int[][] b = new int[3][3];
		for(int r=0;r<a.length; r++)
		{
			for(int c=0;c<b.length;c++)
			{
				b[r][c]= a[c][r];
			}
		}
		for(int r=0;r<a.length;r++)
		{
			for(int c=0;c<b.length;c++)
			{
				System.out.print(b[r][c]+" ");
			}
			System.out.println();
		}
	}
	
	public void arrayAddition()
	{
		int[][] a = {{1,2},{3,4}};
		int[][] b= {{2,3},{4,5}};
		int[][] c=new int[2][2];
		for(int row=0;row<a.length;row++)
		{
			for(int col=0;col<a[row].length;col++)
			{
				c[row][col]=a[row][col]+b[row][col];
			}
		}
		for(int row=0;row<a.length;row++)
		{
			for(int col=0;col<a[row].length;col++)
			{
				System.out.print(c[row][col]+"\t");
			}
			System.out.println();
		}
	}
	public void arraylength()
	{
		int [][] ar = { {10,20,30},
						{40,50,60},
						{70,80,90}
					  };
	for(int row=0;row<ar.length;row++)
	{
		for(int col=ar[row].length-1;col>=0;col--)
		{
			if(row+col==2)
		System.out.println(ar[row][col]+" ");
		}
		System.out.println();
	}
	}
	public void twoDimension()
	{
		int [][][] ar = new int[2][2][4];
		Scanner sc = new Scanner(System.in);
		for(int student =0; student <2;student++)
		{
		System.out.println("Enter marks");
		int exam=0;
		int total=0;
		while(exam<2)
		{
			total=0;
			for(int sub=0;sub<4;sub++)
			{
				System.out.println("Enter marks");
				ar[student][exam][sub]=sc.nextInt();
				total=total+ar[student][exam][sub];
			}
			System.out.println(total);

			exam++;
		}
	}
	}
		private void binarySearch() {
			int[] ar = {10, 12, 15, 18, 23, 27, 35, 45, 78, 98, 100};
		int min = 0, max = ar.length-1;
		int key = 1234; 
		while(min<=max)
		{
		int mid = (min+max)/2; 
			if(key == ar[mid]) // 45 ==27
			{
			System.out.println("Present at "+ mid);
			break;
			}
			else if(key>ar[mid])
			{
			min = mid+1;
			}
			else if(key<ar[mid])
			{
			max = mid-1; 
			}
		}
		if(min>max)
		{
			System.out.println("No is not present");
		}
		} 
	
	public void linearSearch()
	{
		int [] ar = {5,10,12,14,16};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any no to search");
		int key = sc.nextInt();
		int i=0;
		for(i=0;i<ar.length; i++)
		{
			if(ar[i]==key)
			{
				System.out.println("yes present");
				System.out.println("Present at"+i);
			}
			}
				if(i==ar.length)
		{
			System.out.println("not present");
		
		
		}
				
	}
public void sortArray()
{
	int [] ar= {13,52,71,32,21}; int j=1;
	while(j<=ar.length)
	{
		int i=0;
		while(i<ar.length-j)
		{
			if(ar[i]>ar[i+1])
			{
				int temp=ar[i];
				ar[i]=ar[i+1];
				ar[i+1]=temp;
			}
			i++;
		}
		int len=ar.length;
		j++;
	}
	System.out.println("After Sorting");
	for(int i=0;i<ar.length;i++)
	{
		System.out.println(ar[i]);
	}
}
	
public void secondBig()
{
	int[] ar= {18,5,2,1,60};
	int big=ar[0], sbig=ar[0];
	for(int i=1;i<ar.length;i++)
	{
		int v =ar[i];
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
	System.out.println(big);
	System.out.println(sbig);
}
	
	
	private int[] calculate() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Tell me no of subjects");
		int count = sc.nextInt();
		int [] marks=new int [count];
		int total=0;
		int average=0;
		for(int i=0;i<marks.length;i++)
		{
			System.out.println("Enter mark");
			marks[i]=sc.nextInt();
			total=total+marks[i];
			}
		for(int i=0;i<marks.length;i++)
		{
			System.out.println(marks[i]);
		}
		System.out.println("Total is "+total);
		average=total/count;
		System.out.println("Average is "+average);
		return marks;
	}
}
