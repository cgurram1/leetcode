import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];
        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) freq.put(num, freq.getOrDefault(num, 0) + 1);
        int[] original = new int[changed.length / 2];
        int i = 0;
        for (int num : changed) {
            if (freq.get(num) == 0) continue;
            if (num == 0) {
                if (freq.get(num) < 2) return new int[0];
                freq.put(num, freq.get(num) - 2);
            } else {
                if (freq.getOrDefault(num * 2, 0) == 0) return new int[0];
                freq.put(num * 2, freq.get(num * 2) - 1);
                freq.put(num, freq.get(num) - 1);
            }
            original[i++] = num;
        }
        return original;
    }
}
