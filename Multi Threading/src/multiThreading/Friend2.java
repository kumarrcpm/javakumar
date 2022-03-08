package multiThreading;

public class Friend2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Friend1 fr= new Friend1();
		fr.start();
		 fr.join();
		 fr.interrupt();
		for(int i=1;i<=5;i++)
		{
			
			System.out.println("Friend2 "+i);
			
		}
	}

}
