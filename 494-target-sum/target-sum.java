class Solution {
    public int findTargetSumWays(int[] nums, int target){
        int mathSum = 0;
        for(int i = 0;i<nums.length;i++){
            mathSum += nums[i];
        }
        int [][] dp = new int[nums.length + 1][mathSum * 2 + 1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,nums,target,dp,mathSum);
    }
    public int fun(int index, int sum, int [] nums,int target, int [][] dp,int mathSum){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[index][sum + mathSum] != -1){
            return dp[index][sum + mathSum];
        }
        dp[index][sum + mathSum] = fun(index + 1, sum + nums[index],nums,target,dp,mathSum) + fun(index + 1, sum - nums[index],nums,target,dp,mathSum);
        return dp[index][sum + mathSum];
    }
}