class Solution {
    public int maxProduct(int[] nums) {
        int [] maxEnd = new int[nums.length];
        int [] minEnd = new int[nums.length];
        maxEnd[0] = nums[0];
        minEnd[0] = nums[0];
        int ans = nums[0];
        for(int i = 1;i<nums.length;i++){
            maxEnd[i] = Math.max(nums[i], Math.max(nums[i] * maxEnd[i-1], nums[i] * minEnd[i-1]));
            minEnd[i] = Math.min(nums[i], Math.min(nums[i] * maxEnd[i-1], nums[i] * minEnd[i-1]));
            ans = Math.max(ans, Math.max(maxEnd[i], minEnd[i]));
        }
        return ans;
    }
}