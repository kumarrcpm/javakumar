package swappingNumbersProgram;

public class SwapNumberWithoutThirdVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a=2,b=4;
System.out.println("Before Swap a is "+a);
System.out.println("Before Swap b is "+b);
a=a+b;
System.out.println("a+b is "+a);
b=a-b;
a=a-b;
System.out.println("After Swap a is "+a);
System.out.println("After Swap b is "+b);
	}

}
