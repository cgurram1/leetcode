class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,text1,text2,dp);
    }
    public int fun(int index1, int index2,String text1, String text2,int [][] dp){
        if(index1 >= text1.length() || index2 >= text2.length()){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(text1.charAt(index1) == text2.charAt(index2)){
            dp[index1][index2] = 1 + fun(index1 + 1, index2 + 1,text1,text2,dp); 
            return dp[index1][index2];
        }
        else{
            int moveLeft = fun(index1 + 1, index2,text1,text2,dp);
            int moveRight = fun(index1, index2 + 1,text1,text2,dp);
            dp[index1][index2] = Math.max(moveLeft, moveRight);
            return dp[index1][index2];
        }
    }
}