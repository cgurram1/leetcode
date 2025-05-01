class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0;i<hand.length;i++){
            if(map.containsKey(hand[i])){
                map.put(hand[i], map.get(hand[i]) + 1);
            }
            else{
                map.put(hand[i],1);
            }
        }
        while(map.isEmpty() == false){
            int start = map.firstKey();
            for(int i = 0;i<groupSize;i++){
                int toAdd = start + i;
                if(map.containsKey(toAdd) == false){
                    return false;
                }
                map.put(toAdd, map.get(toAdd) - 1);
                if(map.get(toAdd) == 0){
                    map.remove(toAdd);
                }
            }   
        }
        return true;
    }
}