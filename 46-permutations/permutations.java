class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] numsG;

    public List<List<Integer>> permute(int[] nums) {
        numsG = nums;
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), used);
        return result;
    }

    private void backtrack(List<Integer> curr, boolean[] used) {
        if (curr.size() == numsG.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < numsG.length; i++) {
            if (used[i]) continue;      // already used

            used[i] = true;
            curr.add(numsG[i]);

            backtrack(curr, used);

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
