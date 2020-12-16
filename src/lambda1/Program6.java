package lambda1;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Program6 {
	
	private static final Pattern PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	
	static class User {
		int id;
		String name;
		
		public User(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int id() {
			return id;
		}
		
		public String name() {
			return name;
		}
	}
	
	private static List<User> getUsers() {
		int i = 1;
		return Arrays.asList(
				new User(i++, "Jo�o Saldanha"),
				new User(i++, "Jo�o-Saldanha"),
				new User(i++, "Jo�o:Saldanha"),
				new User(i++, "Joao Silva"),
				new User(i++, "Gra�a Maria"),
				new User(i++, "Jorge Louren�o"),
				new User(i++, "F�bio Saldanha"),
				new User(i++, "Fabiano Gol�alves")
			);
	}
	
	public static String deAccent(String str) {
		return PATTERN.matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("");
	}
	
	public static Predicate<User> contains(String query) {
		if(query == null || query.isEmpty())
			return user -> false;
		return user -> deAccent(user.name()).toLowerCase(Locale.ROOT).contains(deAccent(query).toLowerCase(Locale.ROOT));
	}
	
	private static List<User> filterUser(String query) {
		return getUsers().stream()
				.filter(contains(query))
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println(filterUser("Jo�o SALDANha"));
		System.out.println(filterUser("Jo�o-saldanha"));
		System.out.println(filterUser("JoAo"));
		System.out.println(filterUser("Gra�a"));
		System.out.println(filterUser("Fabi"));
		System.out.println(filterUser(null));
		System.out.println(filterUser(""));
	}

}
