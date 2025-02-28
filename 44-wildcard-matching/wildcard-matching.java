class Solution {
    public boolean isMatch(String s, String p) {
        int [][] dp = new int[s.length() + 1][p.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return rec(0,0,s,p,dp) == 1;
    }
    public static int rec(int i,int j,String s, String p,int [][] dp){
        if(i >= s.length() && j >= p.length()){
            return dp[i][j] = 1;
        }
        else if(j>= p.length()){
            return dp[i][j] = 0;
        }
        else if(i>= s.length()){
            if(p.charAt(j) != '*'){
                return dp[i][j] = 0;
            }
            else{
                return rec(i,j+1,s,p,dp);
            }
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return rec(i+1,j+1,s,p,dp);
        }
        else if(p.charAt(j) == '*'){
            for(int k = i;k<=s.length();k++){
                if(rec(k,j+1,s,p,dp) == 1){
                    return dp[i][j] = 1;
                }
            }
        }
        else{
            return dp[i][j] = 0;
        }
        return dp[i][j] = 0;
    }
}