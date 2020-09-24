package lambda1;

import java.util.Arrays;
import java.util.List;

public class Program3 {
	
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,5,8,7,4,6,3,2,1,8,5,7,4);
		for(int i = 0; i < 7; i++) {
			Integer numero = lista.get(i);
			if(numero % 2 == 0) {
				System.out.println(numero * 2);
			}
		}
	}

}
