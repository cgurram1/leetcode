class Solution {
    int res = Integer.MAX_VALUE;
    int closest = 0;
    int target;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        for (int base : baseCosts) {
            dfs(toppingCosts, 0, base);
        }
        return closest;
    }
    private void dfs(int[] toppingCosts, int index, int currentCost) {
        int diff = Math.abs(currentCost - target);
        if (diff < res || (diff == res && currentCost < closest)) {
            res = diff;
            closest = currentCost;
        }
        if (index >= toppingCosts.length) return;
        dfs(toppingCosts, index + 1, currentCost);
        dfs(toppingCosts, index + 1, currentCost + toppingCosts[index]);
        dfs(toppingCosts, index + 1, currentCost + 2 * toppingCosts[index]);
    }
}