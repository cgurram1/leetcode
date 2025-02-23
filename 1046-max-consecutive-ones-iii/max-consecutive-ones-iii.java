class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int [] freq = new int[2];
        int res = 0;
        while(r < nums.length){
            freq[nums[r]]+=1;
            if(freq[0] > k){
                freq[nums[l]]-=1;
                l+=1;
            }
            if(freq[0] <= k){
                res = Math.max(res,r - l + 1);
            }
            r+=1;
        }
        return res;
    }
}