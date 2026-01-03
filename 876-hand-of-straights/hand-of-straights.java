/**

[1,2,3,6,2,3,4,7,8]
{
    1: 0
    2: 1
    3: 1
    4: 1
    6: 1
    7: 1
    8: 1
}

 */

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            // System.out.println("1");
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<hand.length;i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        for(int i = 0;i<hand.length;i++){
            if(map.get(hand[i]) > 0){
                map.put(hand[i], map.get(hand[i]) - 1);
                for(int j = hand[i] + 1;j<hand[i]+groupSize;j++){
                    if(map.containsKey(j) == false || map.get(j) == 0){
                        // System.out.println("2");
                        return false;
                    }
                    else{
                        map.put(j, map.get(j) - 1);
                    }
                }
            }
        }
        return true;
    }
}