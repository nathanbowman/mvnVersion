package mvnVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPerformance {
	
	public static void main(String... args) { 
	    String[] array = new String[1000000];
	    Arrays.fill(array, "AbabagalamagA");
	    List<String> arrayList = new ArrayList<String>();
	    for(int z=0; z<array.length; z++) {
	    	arrayList.add(array[z]);
	    }
	    System.out.println("Warmup...");
	    for (int i = 0; i < 100; ++i) {
	        sequential(arrayList);
	        parallel(arrayList);
	    }
	    System.out.println("Benchmark...");
	    for (int i = 0; i < 5; ++i) {
	        System.out.printf("Run %d:  sequential %s  -  parallel %s\n",
	            i, 
	            0,//test(() -> sequential(arrayList)),
	            test(() -> parallel(arrayList)));
	    }
	}
	private static void sequential(List<String> arrayList) {
		arrayList.stream().map(String::toLowerCase).collect(Collectors.toList());
	}
	private static void parallel(List<String> arrayList) {
	    arrayList.parallelStream().map(String::toLowerCase).collect(Collectors.toList());
	}
	private static String test(Runnable runnable) {
	    long start = System.currentTimeMillis();
	    runnable.run();
	    long elapsed = System.currentTimeMillis() - start;
	    return String.format("%4.2fs", elapsed / 1000.0);
	}
}
