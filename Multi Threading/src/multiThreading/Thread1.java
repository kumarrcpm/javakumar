package multiThreading;

public class Thread1 extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Thread 1 " + i);
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("I got Interupted");
			}
		}
	}
}
