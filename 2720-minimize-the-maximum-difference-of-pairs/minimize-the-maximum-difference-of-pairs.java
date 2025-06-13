class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormAtLeastP(nums, p, mid)) {
                ans = mid;
                right = mid - 1;  // Try to minimize further
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFormAtLeastP(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++;  // Skip next to avoid overlap
            }
        }
        return count >= p;
    }
}
