class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for(int [] arr: dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,word1,word2,dp);
    }
    public int fun(int index1, int index2,String w1, String w2, int [][] dp){
        if (index1 == w1.length()) return w2.length() - index2;
        if (index2 == w2.length()) return w1.length() - index1;
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(w1.charAt(index1) == w2.charAt(index2)){
            dp[index1][index2] = fun(index1+1, index2 + 1,w1,w2,dp);
        }
        else{
            int insert = 1 + fun(index1, index2+1,w1,w2,dp);
            int delete = 1 + fun(index1+1, index2,w1,w2,dp);
            int replace = 1 + fun(index1 + 1, index2 + 1,w1,w2,dp);
            dp[index1][index2] = Math.min(Math.min(insert,delete),replace);
        }
        return dp[index1][index2];
    }
}