class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length+1][amount+1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,amount, coins,dp);
    }
    public int fun(int index, int cost, int amount, int [] coins,int [][] dp){
        if(index == coins.length){
            return 0;
        }
        if(cost == amount){
            return 1;
        }
        if(dp[index][cost] != -1){
            return dp[index][cost];
        }
        int pick = 0;
        if(cost + coins[index] <= amount){
            pick = fun(index, cost + coins[index], amount, coins,dp);
        }
        int notPick = fun(index + 1, cost,amount, coins,dp);
        dp[index][cost] = pick + notPick;
        return dp[index][cost];
    }

}