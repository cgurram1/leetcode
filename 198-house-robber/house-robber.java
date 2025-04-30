class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);
        return fun(0,nums,dp);
    }
    public int fun(int index, int [] nums, int [] dp){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + fun(index + 2, nums,dp);
        int notPick = fun(index + 1, nums,dp);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}