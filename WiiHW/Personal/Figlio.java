package Personal;

public class Figlio implements Runnable {
	private Thread t;
	private Lock lock;
	private boolean running = true;
	public Figlio(Lock l){
		lock=l;
		t = new Thread(this,"Figlio");

	}

	public void run() {
			System.out.println("Sono il figlio e aspetto i punti");
			for(int i=0;i<3;i++){
				

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(i);
			}
			System.out.println("Sono il figlio ho ricevuto i punti e attivo il padre");
			lock.Enable();
		System.out.println("Sono il figlio mi disattivato");
		stopThread();
	}
	public void stopThread() {
		running = false;
	}
	public void startThread() {
		System.out.println("Parte il figlio");
		t.start();
	}
}
