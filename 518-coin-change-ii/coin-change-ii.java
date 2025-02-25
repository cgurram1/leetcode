class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][5001];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return rec(0,amount,coins,dp);
    }
    public static int rec(int index,int amountRemaining, int [] coins,int [][] dp){
        if(amountRemaining == 0){
            return 1;
        }
        if(index == coins.length){
            return 0;
        }
        if(dp[index][amountRemaining] != -1){
            return dp[index][amountRemaining];
        }
        int take = 0;
        if(amountRemaining >= coins[index]){
            take = rec(index, amountRemaining - coins[index],coins,dp);
        }
        int notTake = rec(index + 1, amountRemaining,coins,dp);
        dp[index][amountRemaining] = take + notTake;
        return dp[index][amountRemaining];
    }
}