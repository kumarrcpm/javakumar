package innerClass;

public class BankA {

	public static void main(String[] args) {		
		BankA customer = new BankA();
		customer.deposit();
		BankA customer1 = new BankA()
				{
			public void deposit()
			{
				System.out.println("E Deposit");
			}
			};
			customer1.deposit();
	}
	public void deposit() {
		System.out.println("Normal deposit Challan");
	}
	
}
