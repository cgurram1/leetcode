class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid-1 >= 0 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
