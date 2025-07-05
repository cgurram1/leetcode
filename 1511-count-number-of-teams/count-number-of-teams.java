class Solution {
    public int numTeams(int[] rating) {
        int [][] GL = new int[rating.length][2];
        int [][] LG = new int[rating.length][2];
        for(int i = 0;i<rating.length;i++){
            for(int k = 0;k<i;k++){
                if(rating[k] < rating[i]){
                    LG[i][0]++;
                }
                if(rating[k] > rating[i]){
                    GL[i][0]++;
                }
            }
            for(int k = i + 1;k < rating.length;k++){
                if(rating[k] < rating[i]){
                    GL[i][1]++;
                }
                if(rating[k] > rating[i]){
                    LG[i][1]++;
                }
            }
        }
        int res = 0;
        for(int i = 0;i<rating.length;i++){
            res += (GL[i][0] * GL[i][1] + LG[i][0] * LG[i][1]);
        }
        return res;
    }
}