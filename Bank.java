package innerClass;

public class Bank {

	public static void main(String[] args) {
		Bank manager = new Bank();
		manager.creatingBranch();
		
	}

	public void creatingBranch() {
		System.out.println("Creating a branch");
		int minBal=500; // act as a final variable can't change from inner class
		class ZonalBranch
		{
		public void openSystem() {
			System.out.println("System was Opened");
			System.out.println(minBal);
		}	
		}
		
		ZonalBranch zonalManager = new ZonalBranch();
		zonalManager.openSystem();
	}

}
