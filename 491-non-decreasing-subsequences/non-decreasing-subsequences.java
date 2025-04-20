class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        fun(0,new ArrayList<>(), result, nums,set);
        return result;
    }
    public void fun(int index, List<Integer> curr, List<List<Integer>> result, int [] nums, Set<List<Integer>> set){
        if(index == nums.length){
            return;
        }
        if(curr.size() == 0 || nums[index] >= curr.get(curr.size()-1)){
            curr.add(nums[index]);
            if(curr.size() > 1 && !set.contains(curr)){
                List<Integer> addCurr = new ArrayList<>(curr);
                result.add(addCurr);
                set.add(addCurr);
            }
            fun(index + 1, curr, result, nums,set);
            curr.remove(curr.size()-1);
        }
        fun(index + 1, curr, result,nums,set);
    }
}