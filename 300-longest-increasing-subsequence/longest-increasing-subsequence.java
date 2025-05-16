class Solution {
    private int[][] dp;
    private int[] nums;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return fun(0, -1);
    }
    private int fun(int index, int prevIndex) {
        if (index == nums.length) return 0;
        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];
        int taken = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            taken = 1 + fun(index + 1, index);
        }
        int notTaken = fun(index + 1, prevIndex);
        dp[index][prevIndex + 1] = Math.max(taken, notTaken);
        return dp[index][prevIndex + 1];
    }
}