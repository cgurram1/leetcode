class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long total = 0;
        int n = nums.length;
        for (int x : nums) total += x;

        int res = Integer.MAX_VALUE;

        // Case 1 & remainder handling
        long rem = target % total;
        long curr = 0;
        int left = 0;

        // Sliding window on 2 arrays
        for (int right = 0; right < 2 * n; right++) {
            curr += nums[right % n];

            while (curr > rem && left <= right) {
                curr -= nums[left % n];
                left++;
            }

            if (curr == rem) {
                res = Math.min(res, right - left + 1);
            }
        }

        if (rem != 0 && res == Integer.MAX_VALUE) return -1;

        // Full array contribution
        int full = (int)(target / total) * n;
        return rem == 0 ? full : full + res;
    }
}
