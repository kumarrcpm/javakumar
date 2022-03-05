package innerClass;

public class Rbi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainBranch Manager = new MainBranch();
	//	Manager.zonalMeeting();
	MainBranch.ZonalBranch ZonalManager = Manager.new ZonalBranch();
	ZonalManager.accountOpen();
		
	}

}
