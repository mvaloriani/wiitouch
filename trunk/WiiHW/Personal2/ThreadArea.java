package Personal2;

public  class ThreadArea extends Thread {
	private NewArea cal;
	private HW hard;
	private Lock lock;
	
	public ThreadArea(String str,HW hw,Lock lock) {
		
		super(str);
		hard=hw;
		this.lock=lock;
	}
	public void run() {
		cal = new NewArea(hard,lock);
	}
}