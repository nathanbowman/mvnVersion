package mvnVersion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;


public class PredicateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void whenFilterList_thenSuccess(){
	   List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
	   List<String> result = names.stream()
	     .filter(name -> name.startsWith("A"))
	     .collect(Collectors.toList());
	    
	   assertEquals(2, result.size());
	   System.out.println("OUTPUT: " + result.stream().anyMatch((x)->x.equalsIgnoreCase("Adam")));
	   Predicate<Boolean> test1 = x->true;
	   Predicate<Boolean> test2 = x->true;
	   Predicate<Boolean> test3 = x->true;
	   BiPredicate<Boolean,Boolean> test4 = (x,y)->true; 
	   QuadPredicate<Integer, Integer, Integer, Integer> test5 = (a,b,c,d)->{
		   return (a==1&&b==2&&c==3&&d==4); 
	   };
	   //triPredicate(test1,test2,test3);
	   assertTrue(test1.and(test2).and(test3).test(true));
	   assertTrue(test5.test(1, 2, 3, 4));
	   
	}

//	public static <T> triPredicate(Predicate<T> test1, Predicate<T> test2, Predicate<T> test3) {
//		return test1.and(test2).and(test3).test(true); 
//	}
}
