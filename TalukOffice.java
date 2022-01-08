package electionprocess;
public class TalukOffice extends DistrictCollector
{
public static void main (String [] args)
{
NationalElectoralBoard thasildhar = new NationalElectoralBoard();
System.out.println("I am the incharger of this taluk");	
//thasildhar.votingMachine(); // This is private method so cant access
thasildhar.applicationForm();
thasildhar.voterslist();
thasildhar.countingArea();
System.out.println("CEO Name is"  +  thasildhar.stateceoname );
//System.out.println("CEO Age is" + thasildhar.ceoage ); This is private variable so cant access

}

}