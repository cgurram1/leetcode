import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use Min-Heap (size k) to keep only the k most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>(Comparator.comparingInt(entry -> entry.getValue()));

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll(); // Remove least frequent element
            }
        }

        // Step 3: Extract results from heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}