class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int diff = 0;
        for(int i = 1;i<nums.length;i++){
            diff += nums[i] - nums[i-1];
            if(diff > k){
                res+=1;
                diff = 0;
            }
        }
        return res;
    }
}