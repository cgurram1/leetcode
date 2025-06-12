class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i;
        for(i = 1;i<nums.length;i++){
            max = Math.max(max,Math.abs(nums[i] - nums[i-1]));
        }
        return Math.max(max,Math.abs(nums[i-1] - nums[0]));
    }
}