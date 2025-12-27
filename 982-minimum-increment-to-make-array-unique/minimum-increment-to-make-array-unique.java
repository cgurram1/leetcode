class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;
        int nextAllowed = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nextAllowed++;
            if (nums[i] < nextAllowed) {
                moves += nextAllowed - nums[i];
            } else {
                nextAllowed = nums[i];
            }
        }

        return moves;
    }
}
