package cricketcouncil;
public class Ecb extends Icc
{

public static void main (String [] args)
{
System.out.println("I am the ECB president");
Ecb secretary = new Ecb();
secretary.playerStatistics();
secretary.playerSalary();
secretary.umpiredetails();
//secretary.iccAnnualIncome();

secretary.hundred();
}
public void hundred()
{
System.out.println("Only 100 balls match");
}
public void playerStatistics()
{
System.out.println("We have only England player statistics");
}
}