class Solution {
    public int[] numsG;
    public int targetG;
    public Map<Integer, Integer> map;
    public int combinationSum4(int[] nums, int target) {
        numsG = nums;
        targetG = target;
        map = new HashMap<>();
        return fun(0);
    }

    public int fun(int sum) {
        if (sum == targetG) return 1;
        if (sum > targetG)  return 0;
        if(map.containsKey(sum)){
            return map.get(sum);
        }
        int ways = 0;
        for (int x : numsG) {
            if (x == 0) continue;
            ways += fun(sum + x);
        }
        map.put(sum,ways);
        return ways;
    }
}
