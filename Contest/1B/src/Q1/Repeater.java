package Q1;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repeater {
	private String[] givenStrings;
	private char[] distinctChars;
	private int[][] permutations;
	private int nStrings;
	public Repeater(String[] givenStrings){
		this.givenStrings = givenStrings;
	}
	
	public String findLeastActions(){
		if(isAllStringsEqual())
			return "0";
		
		nStrings = givenStrings.length;
		for(int i = 0; i < nStrings; i++){
			String s = givenStrings[i];
			if(distinctChars == null){
				getUniqueChars(s);
				permutations = new int[nStrings][distinctChars.length];
			}
			for(int j = 0; j < distinctChars.length; j++){
				int n = s.length() - s.replace(Character.toString(distinctChars[j]),"").length();
				if(n == 0)
					return "-1";
				permutations[i][j] = n;
			}
		}
		int leastActions = 100000000;
		for(int i = 0; i < nStrings; i++){
			int actions = 0;
			int[] targetPerm = permutations[i];
			for(int j = 0; j < nStrings; j++){
				actions += absoluteDiff(targetPerm, permutations[j]);
				if(actions > leastActions)
					break;		
			}
			if (actions<leastActions)
				leastActions = actions;
			 
		}
		int[] targetPerm = createPermutation(distinctChars.length);
		int actions = 0;
		for(int j = 0; j < nStrings; j++){
			actions += absoluteDiff(targetPerm, permutations[j]);
			if(actions > leastActions)
				break;		
		}
		if (actions<leastActions)
			leastActions = actions;
		
		return Integer.toString(leastActions);

	}
	private int absoluteDiff(int[] a, int[] b){
		if(a == b)
			return 0;
		int total = 0;
		for(int i = 0; i < a.length; i++){
			int n = a[i] - b[i];
			total += (n < 0) ? -n : n;
		}
		return total;
		
	}
	private int[] createPermutation(int n){
		int[] l = new int[n];
		
		for(int i = 0; i < n; i++){
			int max = 0;
			int toSave = 0;
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < nStrings;j++){
					list.add(permutations[j][i]);
			}
			for(int e:list){
				int occur = Collections.frequency(list, e);
				if(occur > max){
					max = occur;
					toSave = e;
				}
			}
			l[i] = toSave;
		}
		return l;
		
	}
	
	private boolean isAllStringsEqual() {
		String first = givenStrings[0];
        for (String element : givenStrings) {
            if (element != first) {
                return false;
            }
        }
        return true;
	}
	
	private void getUniqueChars(String s){
		List<Character> list = new ArrayList<Character>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!list.contains(c))
				list.add(c);
		}
		char[] distinct = new char[list.size()];
		for(int i = 0; i < list.size();i++){
			distinct[i] = list.get(i);
		}
		distinctChars = distinct;
		
	}
	

}
