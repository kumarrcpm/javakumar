//Create a Class named “Trainer”.
//– Have default instance variables String dept, institute
//– Assign values – “Java”, “Payilagam” to them
//– Have private instance variable int salary
//– Assign 10000 as value for salary.
//– Create getter method for salary.
//– Have instance method training() with void as return data type
//– Add a print statement inside training() method
//– Have instance named as ‘trainerKumar’ and pass “CSE”, “payilagam” as arguments to it.
//– Handle above line with matching Constructor.

package scenario1;

public class Trainer {
String dept="java";
String institute="payilagam";
private int salary=10000;
public Trainer(String dept,String institute)
{
	System.out.println(dept);
	System.out.println(institute);
}
public static void main(String [] args)
{
	Trainer trainerkumar = new Trainer("cse", "payilagam");
	trainerkumar.training();
}
public int getSalary() 
{
	return salary;
}
public void training()
{
	System.out.println("Training");
}
}
