//Create a sub class “SQLTrainer” under “Trainer”.
//– Have main method in it.
//– Create instance ram for this class
//– Handle with proper super class constructor
//– Access parent class instance variables
//– Call parent class instance method training()
//– Access salary using getter method in parent class
package scenario1;

public class SQLTrainer extends Trainer {
public SQLTrainer()
{
	super("cse","payilagam");

	this.dept="cse";
	this.institute="payilagam";
	//System.out.println(dept);
	//System.out.println(institute);
}
public static void main(String[] args) 
{
SQLTrainer ram = new SQLTrainer();
ram.training();
ram.getSalary();
}
//System.out.println(super.dept);
//System.out.println(super.institute);

}