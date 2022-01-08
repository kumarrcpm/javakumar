package partyelectionprocess;
import electionprocess.NationalElectoralBoard;
public class PartyOffice extends NationalElectoralBoard 
{

public static void main(String [] args)
{
PartyOffice secretary = new PartyOffice();
System.out.println("I am the Party Secretary");	
//secretary.votingMachine(); // This is private method so cant access
secretary.applicationForm();
secretary.voterslist();
//secretary.countingArea(); // This is default so cant access from another package
System.out.println("CEO Name is"  +  secretary.stateceoname );
//System.out.println("CEO Age is" + stateceo.ceoage ); This is private variable so cant access
}

}