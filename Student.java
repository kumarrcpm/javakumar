public class Student
{
static int std = 5;
int mark1,mark2; //global variables
public static void main(String[] args)
{
System.out.println(std);
Student s1 = new Student();
	s1.calculateTotal();       //calling statement
}
public void calculateTotal()
{
	int m1=90, m2=100;   //method local variables
	int result = m1+m2;
	System.out.println(result);
}
}