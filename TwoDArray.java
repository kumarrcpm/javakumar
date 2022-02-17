package twoDimensionalArray;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoDArray twoD= new TwoDArray();
		//twoD.twoDimension();
		//twoD.arrayAddition();
		//twoD.arrayMultiplication();
		//twoD.addingValuesinArray();
		twoD.FindingNegativeValues();
	}
	
		private void FindingNegativeValues() {
		// TODO Auto-generated method stub
		
	}



	private void addingValuesinArray() {
		int[][]a = {{5,10,15},{1,2,3},{2,4,6}};
		int[][]b = {{1,2,3},{2,4,6},{7,8,9}};
		System.out.println("First Array");
		for(int row=0;row<a.length;row++)
		{
			for(int col=0;col<a.length;col++)
			{
				System.out.print(a[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("Second Array");
		for(int row=0;row<b.length;row++)
		{
			for(int col=0;col<b.length;col++)
			{
				System.out.print(b[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("After Adding values");
		System.out.println("First Array");
		for(int row=0;row<a.length;row++)
		{
			for(int col=0;col<a.length;col++)
			{
				System.out.print(a[row][col]+5+" ");
			}
			System.out.println();
		}
		System.out.println("Second Array");
		for(int row=0;row<b.length;row++)
		{
			for(int col=0;col<b.length;col++)
			{
				System.out.print(b[row][col]+5+" ");
			}
			System.out.println();
		}
	}



	private void arrayMultiplication() {
	
			int[][] a = {{2,4,6},{1,2,3},{3,6,9}};
			int[][] b = {{1,2,3},{2,4,6},{6,7,8}};

			System.out.println("First Array");

			for(int row=0;row<a.length;row++)
			{
				for(int col=0;col<a[row].length;col++)
				{
					System.out.print(a[row][col]+" ");
				}
				System.out.println();
			}
			System.out.println("Second Array");

			for(int row=0;row<b.length;row++)
			{
				for(int col=0;col<b[row].length;col++)
				{
					System.out.print(b[row][col]+" ");
				}
				System.out.println();
			}
			System.out.println("Multiplcation of Two Array");
			int[][] c = new int[3][3];
				for(int row=0;row<c.length;row++)
			{
				
				for(int col=0;col<c[row].length;col++)
				{

				for(int colC=0;colC<c.length;colC++)
				{
			c[row][col]=(a[row][colC])*(b[colC][col])+c[row][col];
				}
			System.out.print(c[row][col]+" ");
			
				}
				System.out.println();
			}
					
	}

	public void arrayAddition()
	{
		int[][] a = {{2,4,6},{1,2,3},{3,6,9}};
		int[][] b = {{1,2,3},{2,4,6},{6,7,8}};

		System.out.println("First Array");

		for(int row=0;row<a.length;row++)
		{
			for(int col=0;col<a[row].length;col++)
			{
				System.out.print(a[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("Second Array");

		for(int row=0;row<b.length;row++)
		{
			for(int col=0;col<b[row].length;col++)
			{
				System.out.print(b[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("Addition of Two Array");
		int[][] c = new int[3][3];
		for(int row=0;row<c.length;row++)
		{
			for(int col=0;col<c[row].length;col++)
			{
				c[row][col]= a[row][col]+b[row][col];
				System.out.print(c[row][col]+" ");
			}
			System.out.println();
		}
				}
	
	public void twoDimension()
	{
		Scanner sc = new Scanner(System.in);
		int [] [] number = new int[3][3];
		System.out.println("Enter your Number");
		for(int i=0;i<number.length;i++)
		{
			for(int j=0;j<number.length;j++)
			{
				number[i][j]= sc.nextInt();
			}
		}
		int total=0;
		int rem;
	  for(int i=0;i<number.length;i++)
	  {
		 //int total=0;
		  for(int j=0;j<number.length;j++)
		  {		
			  System.out.print(number[i][j]+" ");
			//  rem=i+j%30;
			  if(i+j%30==0) {
			  total=total+number[i][j];}
		  }
		  System.out.println();
		//	System.out.println("Multiplication of 30 Total "+total);
	  }  
		System.out.println("Multiplication of 30 Total "+total);
}
	}
