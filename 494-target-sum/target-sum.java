class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return fun(0,0,nums,target);
    }
    public int fun(int index, int sum, int [] nums,int target){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        return fun(index + 1, sum + nums[index],nums,target) + fun(index + 1, sum - nums[index],nums,target);
    }
}