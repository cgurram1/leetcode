class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length < 3){
            return new int[]{nums[1],nums[0]};
        }
        int [] prefix = new int[nums.length];
        int [] suffix = new int[nums.length];
        int [] result = new int[nums.length];
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix,1);
        prefix[1] = nums[0];
        suffix[nums.length-2] = nums[nums.length-1];
        for(int i = 2;i<nums.length;i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        for(int i = nums.length-3;i>=0;i--){
            suffix[i] = nums[i+1] * suffix[i+1];
        }
        for(int i = 0;i<nums.length;i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}