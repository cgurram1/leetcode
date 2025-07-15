class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while(right - left > 1){
            int mid = (left + right)/2;
            //if left is sorted
            if(nums[left] < nums[mid]){
                min = Math.min(min,nums[left]);
                left = mid + 1;
            }
            //if right is sorted
            else{
                min = Math.min(min,nums[mid]);
                right = mid - 1;
            }
        }
        if(nums[left] < nums[right]){
            return Math.min(nums[left],min);
        }
        else{
            return Math.min(nums[right],min);
        }
    }
}