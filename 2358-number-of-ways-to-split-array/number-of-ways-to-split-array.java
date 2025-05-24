class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        long curr = 0;
        for(int i = 0;i<nums.length-1;i++){
            curr+=nums[i];
            if(curr >= sum - curr){
                count+=1;
            }
        }
        return count;
    }
}