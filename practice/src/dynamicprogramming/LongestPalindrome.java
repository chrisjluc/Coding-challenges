package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by chrisjluc on 2014-10-15.
 */
public class LongestPalindrome {

    public static void main(String... args_){
        String s = "heyelleracecarerrolololol";
        System.out.println(longestPalindromeInString(s));
    }

    public static String longestPalindromeInString(String s){
        int[] pCount = new int[s.length()];
        Arrays.fill(pCount, 0);

        for(int i = 1; i < s.length(); i++){
            int offset = pCount[i-1];
            if(s.charAt(i - 1 - offset) == (s.charAt(i)))
                pCount[i] = offset + 2;
            else {
                pCount[i] = 0;
                if(i - 2 > 0 && s.charAt(i - 2) == (s.charAt(i)))
                    pCount[i] = 3;
            }
        }

        int index = 0;
        int longest = 0;
        for(int i = 0; i < pCount.length; i++){
            if(longest < pCount[i]){
                index = i;
                longest = pCount[i];
            }
        }

        return s.substring(index-longest+1,index+1);
    }
}
