package twoDimensionalArray;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TwoDArray twoD= new TwoDArray();
		twoD.twoDimension();
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

	  for(int i=0;i<3;i++)
	  {
		  for(int j=0;j<3;j++)
		  {
			  if(i==j) {
				  total=total+number[i][j];
			  }
			  System.out.print(number[i][j]+" ");
		  }
		  
		  System.out.println();
}
		 System.out.println("Diagonal wise Total"+total);

	}
}