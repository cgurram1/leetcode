class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left] < nums[right]){
            return nums[left];
        }
        while(left < right-1){
            int mid = (left+right)/2;
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid] > nums[left]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
}