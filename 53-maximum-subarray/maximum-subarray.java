class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = nums[0];
        for(int i = 1;i<nums.length;i++){
            res = Math.max(res,sum);
            if(sum + nums[i] < nums[i]){
                sum = nums[i];
            }
            else{
                sum = sum + nums[i];
            }
        } 
        return Math.max(res,sum);
    }
}