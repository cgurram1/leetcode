class Solution {
    static final long MOD = 1_000_000_007L;

    public int maximumProduct(int[] nums, int k) {
        long res = 1; // changed to long
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pq.add(1);
                k -= 1;
            } else {
                pq.add(nums[i]);
            }
        }

        if (k < 0) {
            return 0;
        }

        // increment smallest elements
        while (k > 0) {
            int num = pq.poll();
            pq.add(num + 1);
            k--;
        }

        // compute product at the end (CRITICAL FIX)
        while (!pq.isEmpty()) {
            res = (res * pq.poll()) % MOD;
        }

        return (int) res;
    }
}
