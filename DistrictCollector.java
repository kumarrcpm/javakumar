package electionprocess;
public class DistrictCollector extends StateElectionOffice
{

public static void main(String [] args)
{
NationalElectoralBoard districtceo = new NationalElectoralBoard();
System.out.println("I am the District CEO of this election");	
//districtceo.votingMachine(); // This is private method so cant access
districtceo.applicationForm();
districtceo.voterslist();
districtceo.countingArea();
System.out.println("CEO Name is"  +  districtceo.stateceoname );
//System.out.println("CEO Age is" + candidate.ceoage ); This is private variable so cant access
}

}