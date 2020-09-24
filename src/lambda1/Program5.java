package lambda1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Program5 {
	
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1,5,8,7,4,6,3,2,1,8,5,7,4);
		
		Stream<Integer> limit = lista.stream().limit(7);
		
		Stream<Integer> filter = limit.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer e) {
				return e % 2 == 0;
			}
		});
		
		Stream<Integer> map = filter.map(new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer e) {
				return e * 2;
			}
		});
		
		map.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
	}
	
}
