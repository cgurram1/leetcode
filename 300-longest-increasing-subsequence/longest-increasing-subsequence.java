class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] vals = new int[nums.length];
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            int max = 0;
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max,vals[j]);
                }
            }
            vals[i] = max+1;
            res = Math.max(vals[i],res);
        }
        return res;

    }
}