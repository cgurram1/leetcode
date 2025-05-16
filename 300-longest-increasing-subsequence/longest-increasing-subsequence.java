import java.util.Arrays;

class Solution {
    public int[] nums;
    public int[][] dp;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return fun(0, -1);
    }

    public int fun(int index, int prevIndex) {
        if (index == nums.length) return 0;
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }
        int pick = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            pick = 1 + fun(index + 1, index);
        }
        int notPick = fun(index + 1, prevIndex);
        dp[index][prevIndex + 1] = Math.max(pick, notPick);
        return dp[index][prevIndex + 1];
    }
}