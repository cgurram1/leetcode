class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(0, amount, coins, dp);
    }

    public int dfs(int index, int remaining, int[] coins, Integer[][] dp) {
        if (remaining == 0) return 1;
        if (index == coins.length || remaining < 0) return 0;
        if (dp[index][remaining] != null) return dp[index][remaining];
        int pick = dfs(index, remaining - coins[index], coins, dp);
        int notPick = dfs(index + 1, remaining, coins, dp);
        return dp[index][remaining] = pick + notPick;
    }
}
