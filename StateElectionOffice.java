package electionprocess;
public class StateElectionOffice 
{

public static void main(String [] args)
{
NationalElectoralBoard stateceo = new NationalElectoralBoard();
System.out.println("I am the State CEO");	
//stateceo.votingMachine(); // This is private method so cant access
stateceo.applicationForm();
stateceo.voterslist();
stateceo.countingArea();
System.out.println("CEO Name is"  +  stateceo.stateceoname );
//System.out.println("CEO Age is" + stateceo.ceoage ); This is private variable so cant access
}

}