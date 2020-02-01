/**
 * 
 */
package mvnVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.stream.Collectors;

/**
 * @author nate_
 *
 */
public class LambdaTest {
	private String name; 
	@SuppressWarnings("unused")
	private Long lnum[] = new Long[5];
	
	public LambdaTest(String name) {
		this.setName(name); 
	}

	public void test() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("John", "Freddy", "Samuel");
		names.forEach(name -> System.out.println("Hello, " + name));
		
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);
		
		BiConsumer<String,Integer> test = (x, y) -> System.out.println(x + " is " + y + " years old");
		
		ages.forEach(test);
		
		List<LambdaTest> list=new ArrayList<LambdaTest>();  
		for(int i = 0; i < 1000000; i++) {
			list.add(new LambdaTest("Rick"));         
			list.add(new LambdaTest("Negan"));       
			list.add(new LambdaTest("Daryl"));         
			list.add(new LambdaTest(null));         
			list.add(new LambdaTest("Carl")); 
		}
		long start = System.currentTimeMillis();       
		for(int s1=0; s1<500; s1++) {
			list.parallelStream()
			.filter(x -> x.getName() != null)			
			.collect(Collectors.toList()).parallelStream().filter(x->x.getName().equals("Rick"));
			//.forEach(x->System.out.println(x.getName()));
		}

		long finish = System.currentTimeMillis();
		double timeElapsed = (finish - start)/1000.0;
		System.out.printf("Elapsed Time Stream1: %4.2fs \n", timeElapsed);
		
	    start = System.currentTimeMillis();  
	    for(int s2=0; s2<500; s2++) {
			list.stream()
			.filter(x -> x.getName() != null)			
			.collect(Collectors.toList()).stream().filter(x->x.getName().equals("Rick"));
	    }

			//.forEach(x->System.out.println(x.getName()));
		finish = System.currentTimeMillis();
		timeElapsed = (finish - start)/1000.0;
		System.out.printf("Elapsed Time Stream2: %4.2fs \n", timeElapsed);
	//	list.forEach(          
				// lambda expression        
				//(names)->System.out.println(names)         
				//(x)->System.out.println(x.length())
				
				//); 

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
