package Personal2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock lock = new Lock();

		System.out.println("creo il padre");
		Padre p = new Padre(lock);
		p.startThread();
		System.out.println("fine main");
	}



}
