package Personal2;

public class Padre implements Runnable {
	private Thread t;
	private Lock lock;
	private Figlio f;
	private boolean running = true;
	public Padre(Lock l){
		lock=l;
		t = new Thread(this);
		System.out.println("creo il figlio");
		f = new Figlio(lock);
	}

	public void run() {
		System.out.println("Sono il padre attivo il figlio");
		f.startThread();

		System.out.println("Sono il padre: mi disattivo:");
		lock.Disable();
		
		System.out.println("Sono il padre e mi disattivo");
		stopThread();
		
	}
	public void stopThread() {
		running = false;
	}
	public void startThread() {
		System.out.println("Parte il padre");
		t.start();
	}
}
