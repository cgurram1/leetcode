class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return rec(s,0,dp);
    }
    public static int rec(String next,int index,int [] dp){
        if(index == next.length()){
            return 1;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int one = 0;
        int two = 0;
        if(Integer.valueOf(next.substring(index, index + 1)) > 0 && Integer.valueOf(next.substring(index, index + 1)) < 10){
            one = rec(next,index+1,dp);
        }
        if(index + 1 < next.length()){
            if(Integer.valueOf(next.substring(index, index + 1)) != 0 && Integer.valueOf(next.charAt(index) + "" + next.charAt(index + 1)) <= 26){
                two = rec(next,index+2,dp);
            }
        }
        return dp[index] = one + two;
    }
}