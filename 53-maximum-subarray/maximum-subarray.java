class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] >= currSum + nums[i]){
                currSum = nums[i];
            }
            else{
                currSum += nums[i];
            }
            result = Math.max(result, currSum);
        }
        return result;
    }
}