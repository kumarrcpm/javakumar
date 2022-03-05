package innerClass;

public class MainBranch {

	static String managerName = "Kumar";
	int minBalance = 500;
	int interest = 8;
	public static void main(String[] args) {
		MainBranch manager = new MainBranch();
		// MainBranch.ZonalBranch zonalManager = manager.new ZonalBranch();
		// zonalManager.accountOpen();
		manager.zonalMeeting();
	}
	public void zonalMeeting() {
		ZonalBranch ZonalManager = new ZonalBranch();
		ZonalManager.accountOpen();
	}

	class ZonalBranch {
		int interest = 7;

		public void accountOpen() {
			int interest = 9;
			System.out.println("Account opened");
			System.out.println(managerName);
			System.out.println(minBalance);
			System.out.println("Method Interest " + interest);
			System.out.println("Zonal Interest " + this.interest);
			System.out.println("Main Branch Interest " + MainBranch.this.interest);
		}

	}

}
