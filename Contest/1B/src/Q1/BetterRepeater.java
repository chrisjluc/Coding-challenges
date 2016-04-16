package Q1;

import java.nio.charset.Charset;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetterRepeater {
	private String[] givenStrings;
	private int nStrings;

	public BetterRepeater(String[] givenStrings) {
		this.givenStrings = givenStrings;
		nStrings = givenStrings.length;
	}

	public String findLeastActions() {
		
		int leastActions = 0;
		while (!givenStrings[0].isEmpty()) {
			if (isAllIndicesEqual(0)) {
				int[] occurences = countRepeatedOccurences(givenStrings[0]
						.charAt(0));
				int actions = Integer.MAX_VALUE;
				for(int i = 0; i < nStrings; i++){
					int currentAction = 0;
					for(int j = 0; j < nStrings; j++){
						int a = occurences[i] - occurences[j];
						currentAction += a < 0? -a : a;
					}
					if (currentAction < actions)
						actions = currentAction;
				}
				leastActions += actions;
				//Substring the strings
				for(int i = 0; i < nStrings; i++){
					givenStrings[i] = givenStrings[i].substring(occurences[i]);
				}
			} else {
				return "-1";
			}
			
		}
		return Integer.toString(leastActions);

	}

	private int[] countRepeatedOccurences(char c) {
		int[] occurences = new int[nStrings];
		for (int i = 0; i < nStrings; i++) {
			int count = 0;
			String s = givenStrings[i];
			while (!s.isEmpty() && s.charAt(0) == c) {
				s = s.substring(1);
				count++;
			}
			occurences[i] = count;
		}
		return occurences;
	}

	private boolean isAllIndicesEqual(int index) {
		for (int i = 1; i < nStrings; i++) {
			if (givenStrings[i].isEmpty() || givenStrings[i].charAt(index) != givenStrings[0].charAt(index))
				return false;
		}
		return true;
	}
}
