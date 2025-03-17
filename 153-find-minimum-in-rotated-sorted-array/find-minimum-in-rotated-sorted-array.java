class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right)/2;
            res = Math.min(res,nums[mid]);
            if(nums[right] < nums[mid]){
                left = mid + 1;
            }
            else{
                    right = mid - 1;
            }
        }
        return res;
    }
}