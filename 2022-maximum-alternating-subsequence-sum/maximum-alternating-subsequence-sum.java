class Solution {
    public long maxAlternatingSum(int[] nums) {
        Long[][] dp = new Long[nums.length][2];
        return fun(0, 0, nums, dp);
    }

    public long fun(int index, int decision, int[] nums, Long[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][decision] != null) return dp[index][decision];

        long pick, notPick;
        if (decision == 0) {
            pick = nums[index] + fun(index + 1, 1, nums, dp);
            notPick = fun(index + 1, 0, nums, dp);
        } else {
            pick = -nums[index] + fun(index + 1, 0, nums, dp);
            notPick = fun(index + 1, 1, nums, dp);
        }

        return dp[index][decision] = Math.max(pick, notPick);
    }
}
