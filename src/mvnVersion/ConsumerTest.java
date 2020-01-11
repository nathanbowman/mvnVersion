package mvnVersion;
import java.util.ArrayList; 
import java.util.List; 
import java.util.function.Consumer;
import java.util.function.Predicate; 

public class ConsumerTest {
	public static void main(String args[]) 
    { 
        // Consumer to display a number 
        Consumer<Integer> display = a -> System.out.println(a); 
  
        // Implement display using accept() 
        display.accept(10); 
  
        // Consumer to multiply 2 to every integer of a list 
        Consumer<List<Integer> > modify = list -> 
        { 
            for (int i = 0; i < list.size(); i++) 
                list.set(i, 2 * list.get(i)); 
        }; 
        
        
  
        // Consumer to display a list of numbers 
        Consumer<List<Integer> > 
            dispList = list -> list.stream().forEach(a -> System.out.print(a + " ")); 
            
        Consumer<List<Integer>> square = list -> {
            for (int i = 0; i < list.size(); i++) 
                list.set(i, (list.get(i)*list.get(i))); 
        };
  
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(200); 
        list.add(100); 
        list.add(300); 
  
        // Implement modify using accept() 
        //modify.accept(list); 
  
        // Implement dispList using accept() 
        square.andThen(dispList).accept(list); 
    }
}
