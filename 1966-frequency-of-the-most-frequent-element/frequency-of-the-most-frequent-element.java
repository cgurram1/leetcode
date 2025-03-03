import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int right = nums.length - 1;
        int left = right - 1;
        int currMax = 1;
        int diff = 0;

        while (right >= 0) {
            while (left >= 0 && diff + (nums[right] - nums[left]) <= k) {
                diff += nums[right] - nums[left];
                left--;
            }
            currMax = Math.max(currMax, right - left);
            if (right > 0) {
                diff -= (nums[right] - nums[right - 1]) * (right - left - 1);
            }
            right--;
        }
        return currMax;
    }
}
