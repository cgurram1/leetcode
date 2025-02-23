class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int curr = 0;
        int N = cardPoints.length;
        for(int i = 0;i<N-k;i++){
            curr+=cardPoints[i];
        }
        int l = 0;
        int r = N-k-1;
        int mini = curr;
        while(r < N-1){
            if(curr < mini){
                mini = curr;
            }
            r+=1;
            curr+=cardPoints[r];
            curr-=cardPoints[l];
            l+=1;
        }
        if(curr < mini){
            mini = curr;
        }
        int total = 0;
        for(int i = 0;i<N;i++){
            total+=cardPoints[i];
        }
        return total - mini;
    }
}