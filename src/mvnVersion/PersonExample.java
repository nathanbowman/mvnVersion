package mvnVersion;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PersonExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 38));
		
		Supplier <Person> supplier = () -> {
			return new Person("Mateo", "Bowman", 4);
		};
		Consumer <Person> consumer = (x) ->{
			System.out.println(supplier.get().toString());
			System.out.println("Hello From Another Thread");
		};
		
		Thread thread = new Thread(() -> consumer.accept(supplier.get()));
		thread.start();
		
		
		
//		people.stream().sorted(
//				(n1,n2)->n1.getLastName()
//					.compareTo(n2.getLastName()))
//						.collect(Collectors.toList())
//							.stream().filter(
//									x->x.getLastName()
//									.startsWith("C"))
//									.forEach(x->System.out.println(x));;
	}

}
