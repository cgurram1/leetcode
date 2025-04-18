class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int [] arr: dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        return fun(0,0,triangle,dp);
    }
    public int fun(int level,int j,List<List<Integer>> triangle,int [][] dp){
        if(level == triangle.size()-1){
            return triangle.get(level).get(j);
        }
        if(dp[level][j] != Integer.MIN_VALUE){
            return dp[level][j];
        }
        int min = Integer.MAX_VALUE;
        for(int i = j;i<j+2;i++){
            min = Math.min(fun(level+1,i,triangle,dp),min);
        }
        dp[level][j] = triangle.get(level).get(j) + min;
        return dp[level][j];
    }
}