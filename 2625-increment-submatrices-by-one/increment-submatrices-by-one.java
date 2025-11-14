class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] res = new int[n][n];
        for(int i = 0;i<queries.length;i++){
            for(int x = queries[i][0];x<=queries[i][2];x++){
                for(int y = queries[i][1];y<=queries[i][3];y++){
                    res[x][y]+=1;
                }
            }
        }
        return res;
    }
}