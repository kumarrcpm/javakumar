package myproject;
import java.util.Scanner;
public class Weaving {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weaving saree = new Weaving();
		saree.threadCalculation();
		//saree.normalSareeDesign();
		saree.sareeDesignSelection();
		
	}


	private void sareeDesignSelection() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Select your Saree Design");
		System.out.println("1. Normal Saree 2.Line Saree 3.Big Border Saree");
		int design=sc.nextInt();
		if(design==1)
		{
			System.out.println("You are Selected Normal Design Saree");
			System.out.println("For this two colors of thread is required");
			System.out.println("Select your color combination");
			System.out.println("First Main Color");
			System.out.println("1.Red 2.Blue 3.Yellow 4.Pink");
			int mainColor=sc.nextInt();
			if(mainColor==1)
				System.out.println("Your Main Color is Red");
			if(mainColor==2)
				System.out.println("Your Main Color is Blue");
			if(mainColor==3)
				System.out.println("Your Main Color is Yellow");
			if(mainColor==4)
				System.out.println("Your Main Color is Pink");
			if(mainColor>=5)
				System.out.println("Type correct Number");
			System.out.println("Select Your Border Color");
			System.out.println("1.Orange 2.Sandal 3.Green 4.Grey");
			int borderColor=sc.nextInt();
			if(borderColor==1)
				System.out.println("Your Border Color is Orange");
			if(borderColor==2)
				System.out.println("Your Border Color is Sandal");
			if(borderColor==3)
				System.out.println("Your Border Color is Green");
			if(borderColor==4)
				System.out.println("Your Border Color is Grey");
			if(borderColor>=5)
				System.out.println("Type Correct Number");
			normalSareeDesign();
		}
		if(design==2)
		{
			System.out.println("You are Selected Line Design Saree");
			System.out.println("For this two colors of thread is required");
			System.out.println("Select your color combination");
			System.out.println("First Color");
			System.out.println("1.Red 2.Blue 3.Yellow 4.Pink");
			int firstColor=sc.nextInt();
			if(firstColor==1)
				System.out.println("Your First Color is Red");
			if(firstColor==2)
				System.out.println("Your First Color is Blue");
			if(firstColor==3)
				System.out.println("Your First Color is Yellow");
			if(firstColor==4)
				System.out.println("Your First Color is Pink");
			if(firstColor>=5)
				System.out.println("Type Correct Number");
			System.out.println("Select Your Second Color");
			System.out.println("1.Orange 2.Sandal 3.Green 4.Grey");
			int secondColor=sc.nextInt();
			if(secondColor==1)
				System.out.println("Your Second Color is Orange");
			if(secondColor==2)
				System.out.println("Your Second Color is Sandal");
			if(secondColor==3)
				System.out.println("Your Second Color is Green");
			if(secondColor==4)
				System.out.println("Your Second Color is Grey");
			if(secondColor>=5)
				System.out.println("Type correct Number");
			lineSareeDesign();
		}
		if(design==3)
		{
			System.out.println("You are Selected Big Border Design Saree");
			System.out.println("For this two colors of thread is required");
			System.out.println("Select your color combination");
			System.out.println("First Main Color");
			System.out.println("1.Red 2.Blue 3.Yellow 4.Pink");
			int mainColor=sc.nextInt();
			if(mainColor==1)
				System.out.println("Your Main Color is Red");
			if(mainColor==2)
				System.out.println("Your Main Color is Blue");
			if(mainColor==3)
				System.out.println("Your Main Color is Yellow");
			if(mainColor==4)
				System.out.println("Your Main Color is Pink");
			if(mainColor>=5)
				System.out.println("Type Correct Number");
			System.out.println("Select Your Border Color");
			System.out.println("1.Orange 2.Sandal 3.Green 4.Grey");
			int borderColor=sc.nextInt();
			if(borderColor==1)
				System.out.println("Your Border Color is Orange");
			if(borderColor==2)
				System.out.println("Your Border Color is Sandal");
			if(borderColor==3)
				System.out.println("Your Border Color is Green");
			if(borderColor==4)
				System.out.println("Your Border Color is Grey");
			if(borderColor>=5)
				System.out.println("Type Correct Number");
			
			bigBorderDesignSaree();
		}
		
	}
	public void bigBorderDesignSaree()
	{
		int totalSareeThread =2688;
		System.out.println("totalSareeThread "+totalSareeThread);
		int oneInchThread=56;
		int firstColorThread=40*oneInchThread;
		System.out.println("First Color Thread 40 inch*56 ="+firstColorThread);
		int secondColorThread=8*oneInchThread;
		System.out.println("Second Color Thread 8 inch*56 ="+secondColorThread);
		int leftsideBorder=4*oneInchThread;
		System.out.println("Left Side Border 4 inch*56 ="+leftsideBorder);
		int rightsideBorder=4*oneInchThread;
		System.out.println("Right Side Border 4 inch*56 ="+rightsideBorder);
		int lineSareeDesignThread= firstColorThread+secondColorThread;
		System.out.println("Total Thread for Line Saree Design = "+lineSareeDesignThread);
		
		if(totalSareeThread==lineSareeDesignThread)
			System.out.println("Thread Calculation was done Go for Weaving");
		else
			System.out.println("Check Thread Calculation");	
	}
	public void lineSareeDesign()
	{
		int totalSareeThread =2688;
		System.out.println("totalSareeThread "+totalSareeThread);
		int firstColorThread=(totalSareeThread/2);
		System.out.println("First Color Thread "+firstColorThread);
		int secondColorThread=(totalSareeThread/2);
		System.out.println("Second Color Thread "+secondColorThread);
		int lineSareeDesignThread= firstColorThread+secondColorThread;
		System.out.println("Total Thread for Line Saree Design = "+lineSareeDesignThread);
		
		if(totalSareeThread==lineSareeDesignThread)
			System.out.println("Thread Calculation was done Go for Weaving");
		else
			System.out.println("Check Thread Calculation");
	}

	public void normalSareeDesign()
	{
	int totalSareeThread =2688;
	System.out.println("totalSareeThread "+totalSareeThread);
	int LeftSideBorderColor1=56;
	System.out.println("Left Side Border Color1 is "+LeftSideBorderColor1+" Threads");
	int LeftSideBorderColor2=56;
	System.out.println("Left Side Border Color2 is "+LeftSideBorderColor2+" Threads");
	int RightSideBorderColor1=56;
	System.out.println("Right Side Border Color1 is "+LeftSideBorderColor1+" Threads");
	int RightSideBorderColor2=56;
	System.out.println("Right Side Border Color1 is "+LeftSideBorderColor1+" Threads");
	int RemainingThread=totalSareeThread-(LeftSideBorderColor1+LeftSideBorderColor2+
								RightSideBorderColor1+RightSideBorderColor2);
	System.out.println("Center Thread "+RemainingThread+" Threads");
	int total=LeftSideBorderColor1+LeftSideBorderColor2+RemainingThread+RightSideBorderColor1+RightSideBorderColor2;
	System.out.println("Total Thread for Normal Saree = "+total);
	if(totalSareeThread==total)
	{
		System.out.println("Thread Calculation was done Go for Weaving");
		
	}
	else
		System.out.println("Check Thread Calculation");
	}
	
	private int threadCalculation() {
		// TODO Auto-generated method stub
		int oneInchThread = 56;
		System.out.println(oneInchThread+" Threads For One inch saree");
		int sareeBreadth = 48;
		System.out.println("Saree Breadth is "+sareeBreadth+" inch");
		int totalSareeThread= oneInchThread*sareeBreadth;
		System.out.println("Total Required Threads for one saree 56*48= "+totalSareeThread+" Threads");
		double onesareelength=  5.5;
		System.out.println("One Saree Length "+onesareelength+" Metres");
		int totalweavingsaree=60;
		double totalLength = onesareelength*totalweavingsaree;
		System.out.println("Total Length for 60 saries 60*5.5= "+totalLength+" Metres");
		return totalSareeThread;
	}

}
