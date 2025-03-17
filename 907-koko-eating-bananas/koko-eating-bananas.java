class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;
        while(left <= right){
            int mid = (left + right)/2;
            if(valid(mid,piles,h)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }
    public boolean valid(int k,int [] piles, int h){
        int cum = 0;
        for(int i = 0;i < piles.length;i++){
            cum+=Math.ceil((double)piles[i]/k);
        }
        if(cum <= h){
            return true;
        }   
        return false;
    }
}