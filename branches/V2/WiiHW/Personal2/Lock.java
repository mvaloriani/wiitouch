package Personal2;

public class Lock{
	public Lock(){}
	
	synchronized public void Enable(){
		System.out.println("Attivo il thread padre");
		notify();
	}
	
	synchronized public void Disable() {
		System.out.println("Disattiva il thread padre");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}