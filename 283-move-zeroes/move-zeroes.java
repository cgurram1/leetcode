class Solution {
    public void moveZeroes(int[] nums) {
        int left = -1;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != 0 && left != -1){
                nums[left] = nums[right];
                nums[right] = 0;
                left+=1;
            }
            else if(nums[right] == 0 && left == -1){
                left = right;
            }
            right+=1;
        }
    }
}