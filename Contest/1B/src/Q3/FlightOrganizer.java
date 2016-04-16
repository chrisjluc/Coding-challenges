package Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlightOrganizer {
	static List<String>  s = new ArrayList<String>(Arrays.asList("123","432","234"));
	public static void main(String[] arg0){
		Collections.sort(s);
		System.out.println(s.get(0));
		System.out.println(s.get(1));
		System.out.println(s.get(2));
	}
}
