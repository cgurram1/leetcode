class Solution {
    public long minTime(int[] skill, int[] mana) {
        int M = mana.length, N = skill.length;
        long[][] dp = new long[M][N+1];

        // base row (wizard 0 does all)
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j-1] + (long)mana[0] * skill[j-1];
        }

        // for each subsequent wizard i
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i-1][1];

            // diffAcc[k] will accumulate how much to add to dp[i][0..k-1]
            long[] diffAcc = new long[N+1];

            int j = 1;
            while (j <= N) {
                dp[i][j] = dp[i][j-1] + (long)mana[i] * skill[j-1];

                // your old “if” that would patch dp[i][0..j] by diff
                if (j+1 < dp[0].length && dp[i][j] <= dp[i-1][j+1]) {
                    long diff = dp[i-1][j+1] - dp[i][j];
                    dp[i][j] = dp[i-1][j+1];

                    // instead of looping k from j-1 down to 0,
                    // just mark the range [0..j-1) in diffAcc
                    diffAcc[0] += diff;
                    diffAcc[j] -= diff;
                }
                j++;
            }

            // one more O(N) pass to apply all those diffs to dp[i][*]
            long running = 0;
            for (int k = 0; k <= N; k++) {
                running += diffAcc[k];
                dp[i][k] += running;
            }
        }

        return dp[M-1][N];
    }
}
