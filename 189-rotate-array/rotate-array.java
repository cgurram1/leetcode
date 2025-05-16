class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        fun(0,nums.length-k-1,nums);
        fun(nums.length-k, nums.length-1,nums);
        fun(0,nums.length-1,nums);
    }
    public void fun(int first, int last, int [] nums){
        while(first < last){
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}