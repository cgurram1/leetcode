class Solution {
    int[][] dp;
    int[][] player;

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        player = new int[n][2];

        for (int i = 0; i < n; i++) {
            player[i][0] = scores[i];
            player[i][1] = ages[i];
        }

        // Sort by age, then score
        Arrays.sort(player, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // prevIndex goes from -1 to n-1 → shift by +1
        dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return recFun(0, -1);
    }

    public int recFun(int index, int prevIndex) {
        if (index == player.length) return 0;

        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        // Option 1: skip current player
        int notTake = recFun(index + 1, prevIndex);

        // Option 2: take current player if valid
        int take = 0;
        if (prevIndex == -1 || player[index][0] >= player[prevIndex][0]) {
            take = player[index][0] + recFun(index + 1, index);
        }

        return dp[index][prevIndex + 1] =
                Math.max(take, notTake);
    }
}
