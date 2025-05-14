class Solution {
    public long continuousSubarrays(int[] nums) {
        // Brute Force
        // int left = 0;
        // long result = 0;
        // TreeMap<Integer,Integer> freq = new TreeMap<>();
        // for (int right = 0; right < nums.length; right++) {
        //     freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
        //     while (freq.lastKey() - freq.firstKey() > 2) {
        //         freq.put(nums[left], freq.get(nums[left]) - 1);
        //         if (freq.get(nums[left]) == 0) {
        //             freq.remove(nums[left]);
        //         }
        //         left++;
        //     }
        //     result += right - left + 1;
        // }
        // return result;

        // optimal
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        long result = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            while (maxDeque.peekFirst() - minDeque.peekFirst() > 2) {
                if (nums[left] == maxDeque.peekFirst()) maxDeque.pollFirst();
                if (nums[left] == minDeque.peekFirst()) minDeque.pollFirst();
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}