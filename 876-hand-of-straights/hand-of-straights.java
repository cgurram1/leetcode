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
                Integer count = map.get(toAdd);
                if (count == null) return false;
                if (count == 1) {
                    map.remove(toAdd);
                } else {
                    map.put(toAdd, count - 1);
                }
            }   
        }
        return true;
    }
}