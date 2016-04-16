package sample;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        String[] friends = new String[5];
//        // Should be 3
//        friends[0] = "YYNNN";
//        friends[1] = "YYYNN";
//        friends[2] = "NYYNN";
//        friends[3] = "NNNYN";
//        friends[4] = "NNNNY";

//        // Should be 2
//        friends[0] = "YNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNN";
//        friends[1] = "YYNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNNYNNNN";


        System.out.println(newCubeNumbers(20000, 10000));
    }

    static int newCubeNumbers(int m, int n) {

        List<Integer> perfectCubeM = new ArrayList<Integer>();
        List<Integer> perfectCubeN = new ArrayList<Integer>();

        for(int i = 1; i*i*i <= m; i++)
            perfectCubeM.add(i);

        for(int i = 1; i*i*i <= n; i++)
            perfectCubeN.add(i);

        return perfectCubeM.size() * perfectCubeN.size();
    }

    static int cubeNumbers(int m, int n) {

        HashMap<Integer, Double> thirdPowerByInt = new HashMap<Integer, Double>();

        for(int i = 1; i <= m; i++){
            thirdPowerByInt.put(i, Math.pow(i, (double)1/3));
        }

        if (n > m){
            for(int i = m; i <= n; i++){
                thirdPowerByInt.put(i, Math.pow(i, (double)1/3));
            }
        }
        int count = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                double sum = thirdPowerByInt.get(i) + thirdPowerByInt.get(j);
                if(sum == (int) sum)
                    count++;
            }
        }
        return count;
    }


    static int oldcubeNumbers(int m, int n) {
        int countIntM = 0, countIntN = 0;
        for(double i = 1; i <= m; i++){
            double x = Math.pow(i,(double)1/3);
            if (x == (int)x)
                countIntM++;
        }
        for(double i = 1; i <= n; i++){
            double x = Math.pow(i,(double)1/3);
            if (x == (int)x)
                countIntN++;
        }
        return countIntM * countIntN;
    }

    static int friendCircles(String[] friends) {
        List<BigInteger> binaryRepOfFriends = new ArrayList<BigInteger>();

        for (int i = 0; i < friends.length; i++){
            String binaryRep = friends[i].replace('Y','1').replace('N','0');
            binaryRepOfFriends.add(new BigInteger(binaryRep, 2));
        }

        boolean match;

        do{
            match = false;
            for(int i = 0; i < binaryRepOfFriends.size(); i++){

                for(int j = 0; j < binaryRepOfFriends.size(); j++){
                    if (i == j)
                        continue;

                    BigInteger friendCircle1 = binaryRepOfFriends.get(i);
                    BigInteger friendCircle2 = binaryRepOfFriends.get(j);

                    int isConnected = (friendCircle1.and(friendCircle2)).compareTo(BigInteger.ZERO);
                    // Merge and break out of inner loop
                    if(isConnected == 1){
                        match = true;
                        BigInteger newFriendCircle = friendCircle1.or(friendCircle2);
                        binaryRepOfFriends.set(i,newFriendCircle);
                        binaryRepOfFriends.remove(j);
                        break;
                    }
                }
                // Break out of outer loop
                if(match)
                    break;
            }

        }while(match);

        return binaryRepOfFriends.size();
    }

    static int oldFriendCircles(String[] friends) {

        HashMap<Integer,List<Integer>> friendsByStudentId = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < friends.length; i++){

            char[] charArray = friends[i].toCharArray();
            friendsByStudentId.put(i, new ArrayList<Integer>());

            for (int j = 0; j < charArray.length; j++){
                if (i == j)
                    continue;
                //Find if current id exists then add connection
                if (charArray[j] == 'Y')
                        friendsByStudentId.get(i).add(j);

            }
        }

        List<HashMap<Integer,Integer>> friendGroupsById = new ArrayList<HashMap<Integer, Integer>>();

        for (Map.Entry<Integer, List<Integer>> entry : friendsByStudentId.entrySet()) {
            int id = entry.getKey();
            List<Integer> idFriends = entry.getValue();

                //Find if a any of the id or connections are in the friends by group
            boolean match = false;
            for(HashMap<Integer, Integer> group : friendGroupsById) {
                if (group.containsKey(id))
                    match = true;
                else {
                    for (int friendId : idFriends) {
                        if (group.containsKey(friendId)) {
                            match = true;
                            break;
                        }
                    }
                }
                if(match){
                    group.put(id, 0);
                    for (int val : idFriends)
                        group.put(val,0);
                    break;
                }
            }

            if(!match) {
                HashMap<Integer, Integer> newGroup = new HashMap<Integer, Integer>();
                newGroup.put(id, 0);
                for (int val : idFriends)
                    newGroup.put(val, 0);
            friendGroupsById.add(newGroup);
            }
        }
        return friendGroupsById.size();
    }
}


