class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < nums.length-1 && nums[left] <= nums[left+1]){
            left+=1;
        }
        if(left == nums.length-1){
            return 0;
        }
        while(right > 0 && nums[right] >= nums[right-1]){
            right-=1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Step 4: Extend left and right boundaries
        while (left > 0 && nums[left - 1] > min) left--;
        while (right < n - 1 && nums[right + 1] < max) right++;
        return right - left + 1;
    }
}