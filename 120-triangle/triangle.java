class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return rec(0,0,triangle,dp);
    }
    public int rec(int i,int j,List<List<Integer>> triangle,int [][] dp){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        dp[i][j] = triangle.get(i).get(j) + Math.min(rec(i+1,j,triangle,dp),rec(i+1,j+1,triangle,dp));
        return dp[i][j];
    }
}