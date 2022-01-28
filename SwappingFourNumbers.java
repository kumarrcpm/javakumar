package swappingNumbersProgram;

public class SwappingFourNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a =2, b=4,c=6,d=8;
System.out.println("Before Swap a value is "+a);
System.out.println("Before Swap b value is "+b);
System.out.println("Before Swap c value is "+c);
System.out.println("Before Swap d value is "+d);
a=a+d;
d=a-d;
a=a-d;
b=b+c;
c=b-c;
b=b-c;
System.out.println("After Swap a value is "+a);
System.out.println("After Swap b value is "+b);
System.out.println("After Swap c value is "+c);
System.out.println("After Swap d value is "+d);
//a=8,b=6,c=4,d=2
a=a+d;
d=a-d;
a=a-d;
b=b+c;
c=b-c;
b=b-c;
System.out.println("After Reswap a value is "+a);
System.out.println("After Reswap b value is "+b);
System.out.println("After Reswap c value is "+c);
System.out.println("After Reswap d value is "+d);


	}

}
