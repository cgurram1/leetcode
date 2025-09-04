class Solution {
    int [] candidatesG;
    int targetG;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidatesG = candidates;
        targetG = target;
        fun(0,0,new ArrayList<>());
        return result;
    }
    public void fun(int index, int sum, List<Integer> curr){
        if(sum == targetG){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index == candidatesG.length || sum > targetG){
            return;
        }
        curr.add(candidatesG[index]);
        fun(index, sum + candidatesG[index],curr);
        curr.remove(curr.size()-1);
        fun(index + 1, sum,curr);
    }
}