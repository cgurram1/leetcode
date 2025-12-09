class Solution {
    public int canCompleteCircuit(int[] A, int[] B) {
        int [] cumDiff = new int[A.length];
        int ans = -1;
        int sum = 0;
        int net = 0;
        for(int i = 0;i<A.length;i++){
            cumDiff[i] = A[i] - B[i];
            sum+=cumDiff[i];
            if(sum >= 0){
                if(ans == -1){
                    ans = i;
                }
            }
            else{
                sum = 0;
                ans = -1;
            }
            net+=cumDiff[i];
            
        }
        if(net >= 0){
            return ans;
        }
        return -1;
    }
}