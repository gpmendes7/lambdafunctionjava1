package lambda1;

public class Program2 {
	
	public static void main(String[] args) {
		new Thread(() -> System.out.println("Hello World")).run();
	}
}
