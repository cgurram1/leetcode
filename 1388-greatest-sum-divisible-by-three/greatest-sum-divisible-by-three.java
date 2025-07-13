class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, nums, memo);
    }

    private int dfs(int index, int mod, int[] nums, int[][] memo) {
        if (index == nums.length) {
            return mod == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[index][mod] != -1) return memo[index][mod];
        int newMod = (mod + nums[index]) % 3;
        int take = nums[index] + dfs(index + 1, newMod, nums, memo);
        int skip = dfs(index + 1, mod, nums, memo);
        return memo[index][mod] = Math.max(take, skip);
    }
}
