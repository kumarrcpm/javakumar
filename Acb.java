package cricketcouncil;
public class Acb extends Icc
{

public static void main (String [] args)
{
System.out.println("I am the Acb president");
Acb secretary = new Acb();
secretary.playerStatistics();
secretary.playerSalary();
secretary.umpiredetails();
//secretary.iccAnnualIncome();
secretary.bigbash();
secretary.ipl();
}
public void bigbash()
{
System.out.println("Big bash between among us");
}
public void ipl()
{
System.out.println("We will also join ipl");
}
}