package cricketcouncil;
public class Bcci extends Icc
{

public static void main (String [] args)
{
System.out.println("I am the bcci president");
Bcci secretary = new Bcci();
secretary.playerStatistics();
secretary.playerSalary();
secretary.umpiredetails();
//secretary.iccAnnualIncome();

secretary.ipl();
}
public void ipl()
{
System.out.println("Internal Match between state wise");
}
}