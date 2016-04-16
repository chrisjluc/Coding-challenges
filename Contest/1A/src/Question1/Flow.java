package Question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Flow {

	private final static String NOT_POSSIBLE = "NOT POSSIBLE";
	
	private String[] electricFlow;
	private String[] deviceRequirement;
	private int length;
	private int nDevices;
	private List<String> combinations;

	public Flow(String[] electricFlow, String[] deviceRequirement, int length,
			int nDevices) {
		super();
		this.electricFlow = electricFlow;
		this.deviceRequirement = deviceRequirement;
		this.length = length;
		this.nDevices = nDevices;
	}
	public String findMin(){
		if(isArraysEqual(electricFlow, deviceRequirement))
			return "0";
		int[] n = new int[length];
		for(int i = 0; i < length;i++){
			n[i] = i;
		}
		for(int i = 0; i < length;i++){
			combinations = new ArrayList<String>();
			printCombination(n, length, i+1);
			for(String s:combinations){
				String[] newFlow = electricFlow;
				for(int j = 0; j < s.length();j++){
					int index = Integer.parseInt(s.substring(j, j+1));
					newFlow = flipIndex(index, newFlow);
				}
				if(isArraysEqual(newFlow, deviceRequirement))
					return Integer.toString(i+1);
			}
		}
		return NOT_POSSIBLE;
	}
	
	void printCombination(int arr[], int n, int r)
	{
	    // A temporary array to store all combination one by one
	    int[] data = new int[r];
	 
	    // Print all combination using temprary array 'data[]'
	    combinationUtil(arr, data, 0, n-1, 0, r);
	}
	
	void combinationUtil(int arr[], int data[], int start, int end, int index, int r)
	{
	    // Current combination is ready to be printed, print it
	    if (index == r)
	    {
	    	String s = "";
	        for (int j=0; j<r; j++)
	          s += data[j];
	        combinations.add(s);
	        return;
	    }
	 
	    // replace index with all possible elements. The condition
	    // "end-i+1 >= r-index" makes sure that including one element
	    // at index will make a combination with remaining elements
	    // at remaining positions
	    for (int i=start; i<=end && end-i+1 >= r-index; i++)
	    {
	        data[index] = arr[i];
	        combinationUtil(arr, data, i+1, end, index+1, r);
	    }
	}
	
	
	private String[] flipIndex(int index, String[] previousFlow){
		String[] newFlow = new String[nDevices];
		for(int i = 0; i < nDevices;i++){
			char flipped = previousFlow[i].charAt(index);
			if(flipped == '1')
				flipped = '0';
			else
				flipped = '1';
			newFlow[i] = previousFlow[i].substring(0,index) + 
					flipped + previousFlow[i].substring(index+1,length);
		}
		return newFlow;
	}
	public static boolean isArraysEqual(String[] arr1, String[] arr2) {
	    HashSet<String> set1 = new HashSet<String>(Arrays.asList(arr1));
	    HashSet<String> set2 = new HashSet<String>(Arrays.asList(arr2));
	    return set1.equals(set2);
	}
}
