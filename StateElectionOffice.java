package electionprocess;
<<<<<<< HEAD
public class StateElectionOffice extends NationalElectoralBoard
=======
public class StateElectionOffice 
>>>>>>> 4009d2fa12ae46deb4d3bab2c9c7baf70638c168
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