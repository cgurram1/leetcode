class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[right] == nums[left]){
                right+=1;
            }
            else{
                left+=1;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}