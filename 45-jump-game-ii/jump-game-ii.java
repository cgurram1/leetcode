class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(0, nums, dp);
    }

    public int dfs(int index, int[] nums, int[] dp) {
        if (index >= nums.length - 1) return 0;
        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            int next = dfs(index + i, nums, dp);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }

        return dp[index] = min;
    }
}
