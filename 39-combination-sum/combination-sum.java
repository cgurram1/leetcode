class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        fun(0,0,result,curr,target,candidates);
        return result;
    }
    public void fun(int index, int sum, List<List<Integer>> result, List<Integer> curr,int target,int[] candidates){
        if(sum == target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index == candidates.length || sum > target){
            return;
        }
        curr.add(candidates[index]);
        fun(index,sum + candidates[index],result,curr,target,candidates);
        curr.remove(curr.size()-1);
        fun(index + 1, sum, result,curr,target,candidates);
    }
}