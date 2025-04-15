class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int [] dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);
        int yes = fun(0,1,nums,dp);
        Arrays.fill(dp,-1);
        int no = fun(1,0,nums,dp);
        return Math.max(yes,no);
    }
    public int fun(int index, int flag,int [] nums,int [] dp){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = 0;
        if(flag == 1){
            if(index < nums.length-1){
                pick = fun(index + 2,flag,nums,dp) + nums[index];
            }
        }
        else{
            pick = fun(index + 2,flag,nums,dp) + nums[index];
        }
        int notPick = fun(index + 1,flag,nums,dp);
        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}