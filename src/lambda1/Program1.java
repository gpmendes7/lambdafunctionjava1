package lambda1;

public class Program1 {
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World");
			}
		}).run();
	}

}
