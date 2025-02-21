class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int index = s.length()-1;index>=0;index--){
            int one = 0,two = 0;
            if(Integer.valueOf(s.substring(index, index + 1)) > 0 && Integer.valueOf(s.substring(index, index + 1)) < 10){
                one = dp[index+1];
            }
            if(index + 1 < s.length()){
                if(Integer.valueOf(s.substring(index, index + 1)) != 0 && Integer.valueOf(s.charAt(index) + "" + s.charAt(index + 1)) <= 26){
                    two = dp[index + 2];
                }
            }
            dp[index] = one + two;
        }
        return dp[0];
    }
}