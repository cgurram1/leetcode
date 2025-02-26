class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()][text2.length()];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        return rec(0,0,text1,text2,dp);
    }
    public static int rec(int i,int j,String text1,String text2,int [][] dp){
        if(i > text1.length() - 1 || j > text2.length() - 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int res = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + rec(i + 1,j + 1,text1,text2,dp);
        }
        else{
            res = Math.max(res, Math.max(rec(i,j+1,text1,text2,dp),rec(i+1,j,text1,text2,dp)));
        }
        dp[i][j] = res;
        return dp[i][j];
    }
}