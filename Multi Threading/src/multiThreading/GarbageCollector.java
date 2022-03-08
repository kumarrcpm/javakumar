package multiThreading;

public class GarbageCollector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GarbageCollector[] gcd = new GarbageCollector[100];
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.totalMemory());
		System.out.println(rt.freeMemory());
		rt.gc();
		System.out.println(rt.availableProcessors());
		System.gc();
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());

	}

}
