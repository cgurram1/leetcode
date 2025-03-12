class Solution {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > res + nums[i]){
                res = nums[i];
            }
            else{
                res = res + nums[i];
            }
            result = Math.max(res,result);
        }
        return result;
    }
}