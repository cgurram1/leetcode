class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length + 1][amount + 1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,amount, coins, dp);
    }
    public int fun(int index, int rem, int [] coins, int [][] dp){
        if(rem == 0){
            return 1;
        }
        if(index >= coins.length || rem < 0){
            return 0;
        }
        if(dp[index][rem] != -1){
            return dp[index][rem];
        }
        int pick = fun(index, rem - coins[index], coins,dp);
        int notPick = fun(index + 1, rem, coins,dp);
        dp[index][rem] = pick + notPick;
        return dp[index][rem];
    }
}