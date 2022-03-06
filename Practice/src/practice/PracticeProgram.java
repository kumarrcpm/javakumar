package practice;

public class PracticeProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PracticeProgram user = new PracticeProgram();
		//user.array();
		//user.sorting();
		//user.linearSearch();
		//user.pattern();
		//user.pattern1();
		//user.pattern2();
		//user.pattern3();
		user.factorial();
		
		
		
	}

	private void factorial() {
		// TODO Auto-generated method stub
		int fact=1;
		for(int num=1;num<=5;num++)
		{
			fact=fact*num;
		}
		System.out.println(fact);
	}

	private void pattern3() {
		// TODO Auto-generated method stub
		for(int row=1;row<=5;row++)
		{
			for(int col=2;col<=row;col++)
			{
				System.out.print(" ");
			}
			for(int col1=5;col1>=row;col1--)
			{
				System.out.print(1);
			}
			System.out.println();
		}
	}

	private void pattern2() {
		// TODO Auto-generated method stub
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

	private void pattern1() {
		// TODO Auto-generated method stub
		for(int row =5; row>0; row--)
		{
			for(int col=1;col<=row;col++)
			{
				System.out.print(1);
			}
			System.out.println();
		}
	}

	private void pattern() {
		// TODO Auto-generated method stub
		for(int row=0;row<5;row++)
		{
			for(int col=0; col<=row;col++)
			{
				System.out.print(1);
			}
			System.out.println();
		}
	}

	private void linearSearch() {
		// TODO Auto-generated method stub
		int[] num = {2,1,5,3,4};
		int key=4;
		int i;
		for(i=0;i<num.length;i++)
		{
			if(num[i]==key)
			{
				System.out.println("Number is present");
				break;
			}
		
			if (i>=num.length-1)
			{
				System.out.println("Number is not present");
			}
		}
	}

	private void sorting() {
		// TODO Auto-generated method stub
		int[] num = {2,1,5,3,4};
		for(int j=1;j<=2;j++) {
		for(int i=0;i<num.length-j;i++)
		{
			if(num[i]>num[i+1])
			{
				int temp=num[i+1];
				num[i+1]=num[i];
				num[i]=temp;
			
			}
		}
		}
		int len=num.length;

		System.out.println("Biggest Number is "+num[len-1]);
		System.out.println("Second Biggest Number is "+num[len-2]);

	}

	private void array() {
		// TODO Auto-generated method stub
		int[] num= {83,84,96,87,85};
		int total=0;
		int noOfSub=0;
		int avg=0;
		int big=num[0];
		int sbig=num[0];
		for(int i=0;i<num.length;i++)
		{
			//System.out.println(num[i]);
			if(big<num[i])
			{
				big=num[i];
				
			}
			else if(sbig<num[i])
			{
				sbig=num[i];
			}
			noOfSub++;
			total=total+num[i];
		}
		avg=total/noOfSub;
		System.out.println("Total Marks = "+total);
		System.out.println("No of Subjects = "+noOfSub);
		System.out.println("Average Mark is = "+avg);
		System.out.println("Biggest Mark is "+big);
		System.out.println("Second Biggest = "+sbig);
	}

}
