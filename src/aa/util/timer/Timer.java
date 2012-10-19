package aa.util.timer;

public class Timer {

	private long begin;
	private long end;
	
	public void start() {
		begin = System.currentTimeMillis();
		end = begin;
	}
	
	public void stop() {
		end = System.currentTimeMillis();
	}
	
	public void reset() {
		begin = 0;
		end = 0;
	}
	
	public long elapsed() {
		return (end - begin);
	}
	
	/*
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.start();
		for (int i = 0; i < 1000000; i++)
		  ;
		timer.stop();
		System.out.println(timer.elapsed() + " ms");
		
		timer.reset();
		
		timer.start();
		for (int j = 0; j < 1000000; j++)
		  ;
		timer.stop();
		System.out.println(timer.elapsed() + " ms");
	}
	*/
}
