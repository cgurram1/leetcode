class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
        // int n = piles.length;
        // int[][] memo = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     Arrays.fill(memo[i], Integer.MIN_VALUE);
        // }
        // int net = diff(0, n - 1, piles, memo);
        // return net > 0;
    }
    private int diff(int left, int right, int[] piles, int[][] memo) {
        if (left == right) {
            return piles[left];
        }
        if (memo[left][right] != Integer.MIN_VALUE) {
            return memo[left][right];
        }
        int takeLeft = piles[left] - diff(left + 1, right, piles, memo);
        int takeRight = piles[right] - diff(left, right - 1, piles, memo);

        int ans = Math.max(takeLeft, takeRight);
        memo[left][right] = ans;
        return ans;
    }
}
