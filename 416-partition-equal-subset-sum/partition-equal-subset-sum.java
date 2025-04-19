class Solution {
    int[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new int[nums.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(0, 0, nums, target);
    }

    public boolean fun(int index, int currentSum, int[] nums, int target) {
        if (currentSum == target) return true;
        if (index == nums.length || currentSum > target) return false;

        if (dp[index][currentSum] != -1) {
            return dp[index][currentSum] == 1;
        }

        boolean pick = fun(index + 1, currentSum + nums[index], nums, target);
        boolean skip = fun(index + 1, currentSum, nums, target);

        dp[index][currentSum] = (pick || skip) ? 1 : 0;
        return dp[index][currentSum] == 1;
    }
}