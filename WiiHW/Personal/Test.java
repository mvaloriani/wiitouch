package Personal;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		System.out.println("creo il padre");
		Padre p = new Padre();
		p.startThread();
		System.out.println("fine main");
	}



}
