class Solution {
    public int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        fun(0,0,nums,target);
        return this.result;
    }
    public void fun(int index,int sum,int [] nums,int target){
        if(index == nums.length){
            if(sum == target){
                result+=1;
            }
            return;
        }
        fun(index + 1,sum + nums[index],nums,target);
        fun(index + 1,sum - nums[index],nums,target);
    }
}