class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp = new int[nums.length][nums.length + 1];
        for(int [] arr : dp){
            Arrays.fill(arr, -1);
        }
        return fun(0,-1,nums, dp);
    }
    public int fun(int index, int prev,int[] nums,int [][] dp){
        if(index == nums.length){
            return 0;
        }
        if(prev >= 0 && dp[index][prev + 1] != -1){
            return dp[index][prev + 1];
        }
        int pick = 0;
        if(prev == -1 || nums[prev] < nums[index]){
            pick = 1 + fun(index + 1, index, nums,dp);
        }
        int notPick = fun(index + 1, prev,nums,dp);
        dp[index][prev + 1] = Math.max(pick, notPick);
        return dp[index][prev + 1];
    }
}