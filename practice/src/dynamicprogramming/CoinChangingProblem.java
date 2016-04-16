package dynamicprogramming;

/**
 * Created by chrisjluc on 2014-10-15.
 */
public class CoinChangingProblem {

    public static void main(String... args_){
        // first denom is always 1
        int[] denom = {1,3,4,8,10};
        int target = 505;
        System.out.println(findChange(denom, target));
    }

    private static int findChange(int[] denom, int target) {

        int[][] V = new int[denom.length][target + 1];

        for(int i = 0; i < denom.length; i++){
            for(int j = 1; j < target+1; j++){
                // Trivial row (if denom divides j, save that value, if it doesn't put 0)
                if(i == 0){
                    V[i][j] = 1 + V[i][j-denom[i]];
                }else{
                    if(denom[i] > j){
                        V[i][j] = V[i-1][j];
                    }else{
                        V[i][j] = Math.min(V[i-1][j], 1 + V[i][j-denom[i]]);
                    }
                }
            }
        }
        return V[denom.length-1][target];
    }
}
