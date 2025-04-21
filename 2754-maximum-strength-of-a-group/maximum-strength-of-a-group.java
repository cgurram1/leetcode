class Solution {
    public long maxStrength(int[] nums) {
        long result = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean hasZero = false;
        boolean used = false;

        for (int num : nums) {
            if (num > 0) {
                result *= num;
                used = true;
            } else if (num < 0) {
                pq.add(num);
            } else {
                hasZero = true;
            }
        }

        // If number of negatives is even, use all
        if (pq.size() % 2 == 0) {
            while (!pq.isEmpty()) {
                result *= pq.poll();
                used = true;
            }
        } else {
            // Use all but the least negative one
            while (pq.size() > 1) {
                result *= pq.poll();
                used = true;
            }
            pq.poll(); // skip the smallest negative
        }

        if (!used) {
            // No positives or usable negative pairs
            return hasZero ? 0 : nums[0];  // pick the single negative if needed
        }

        return result;
    }
}
