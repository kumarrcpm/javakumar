package multiThreading;

public class MultiDemo {

	public static void main(String[] args) throws InterruptedException {
		MultiDemo a = new MultiDemo();
		Thread1 b = new Thread1();
		b.start();
		b.interrupt();

		for (int i = 1; i <= 5; i++) {
			//Thread.sleep(2000);
			System.out.println("Demo " + i);
		}
	}
}


