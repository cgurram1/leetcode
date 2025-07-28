class Solution {
    public int countHillValley(int[] nums) {
        int i = 1;
        int count = 0;
        int prev = nums[0];
        while (i < nums.length - 1) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) j++;
            int next = (j < nums.length ? nums[j] : nums[i]);
            if ((prev < nums[i] && next < nums[i]) ||
                (prev > nums[i] && next > nums[i])) {
                count++;
            }
            prev = nums[i];
            i = j;
        }
        return count;
    }
}