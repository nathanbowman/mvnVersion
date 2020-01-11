package mvnVersion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
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
	   
	   
	}

	private String assertThat(List<String> result) {
		// TODO Auto-generated method stub
		return null;
	}

}
