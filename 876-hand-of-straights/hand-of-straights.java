import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        List<Integer> unique = new ArrayList<>(count.keySet());
        Collections.sort(unique);
        for (int num : unique) {
            int freq = count.get(num);
            if (freq > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int next = num + i;
                    if (count.getOrDefault(next, 0) < freq) return false;
                    count.put(next, count.get(next) - freq);
                }
            }
        }
        return true;
    }
}
