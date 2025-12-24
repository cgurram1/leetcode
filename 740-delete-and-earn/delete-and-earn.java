class Solution {
    int [] freqs;
    public int deleteAndEarn(int[] nums) {
        int maxV = 0;
        for(int i = 0;i<nums.length;i++){
            maxV = Math.max(maxV, nums[i]);
        }
        freqs = new int[maxV+1];
        for(int i = 0;i<nums.length;i++){
            freqs[nums[i]]+=1;
        }
        int [] dp = new int[maxV+1+1];
        Arrays.fill(dp,-1);
        return fun(0,dp);
    }
    public int fun(int index,int [] dp){
        if(index >= freqs.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = index * freqs[index] + fun(index + 2,dp);
        int notPick = fun(index + 1,dp);
        dp[index] = Math.max(pick, notPick);
        return Math.max(pick, notPick);
    }
}