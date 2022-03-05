package innerClass;

public class BankC {

	public static void main(String[] args) {

		BankC.BankD manager = new BankC.BankD();
		manager.deposit();
		
	}

	
	static class BankD {
		int bal=500;
		public void deposit()
		{
			System.out.println("Deposit");
		}
	}
}
