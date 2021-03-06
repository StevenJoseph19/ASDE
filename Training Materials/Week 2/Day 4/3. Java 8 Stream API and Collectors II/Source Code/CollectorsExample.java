import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.module2.model.Person;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));

				Stream<String> stream = reader.lines();

		) {

			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;
			}).forEach(System.out::println);
		} catch (IOException e) {

			System.out.println(e);
		}

		Stream<Person> stream = persons.stream();
		
	}
}