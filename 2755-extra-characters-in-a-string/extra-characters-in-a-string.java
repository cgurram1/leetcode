class Solution {
    Set<String> set;
    String s;
    int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        this.s = s;
        set = new HashSet<>(Arrays.asList(dictionary));
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == s.length()) return 0;
        if (dp[i] != -1) return dp[i];
        int ans = 1 + dfs(i + 1);
        
        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j))) {
                ans = Math.min(ans, dfs(j));
            }
        }

        return dp[i] = ans;
    }
}
