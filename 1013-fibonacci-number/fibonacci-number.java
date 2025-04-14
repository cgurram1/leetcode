class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int [] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            int curr = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = curr;
        }
        return dp[1];
    }
}