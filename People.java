package voters;
import electionprocess.NationalElectoralBoard;
public class People
{

public static void main(String [] args)
{
NationalElectoralBoard voter = new NationalElectoralBoard();
System.out.println("I am the Voting person");	
//voter.votingMachine(); // This is private method so cant access
//voter.applicationForm();
voter.voterslist();
//voter.countingArea();
//System.out.println("CEO Name is"  +  voter.stateceoname );
//System.out.println("CEO Age is" + voter.stateceoage ); This is private variable so cant access
}

}