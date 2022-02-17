package twoDimensionalArray;

public class ThreeDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ThreeDArray user = new ThreeDArray();
user.ThreeD();
	}

	public void ThreeD()
	{
		int [][][] marks = new int[2][3][4];
		int value=1;
	//	int total=0;
		for(int i=0;i<2;i++)
		{
			int total=0;
			for(int j=0;j<3;j++)
			{
				//int total=0;
				for(int k=0;k<4;k++)
				{
					//total=0;
					System.out.print(value+" ");
					value++;
					 
				total=total+value;
				}
				System.out.println();
			//System.out.println("Diagonal wise Total"+total);
			}
			System.out.println("Array wise Total"+total);

		}
	}
	}
	
	

