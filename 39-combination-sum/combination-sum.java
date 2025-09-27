class Solution {
    public List<List<Integer>> result;
    int [] candidatesG;
    int targetG;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        candidatesG = candidates;
        targetG = target;
        fun(0,new ArrayList<>(),0);
        return result;
    }
    public void fun(int index, List<Integer> curr,int sum){
        if(sum == targetG){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum > targetG || index == candidatesG.length){
            return;
        }
        curr.add(candidatesG[index]);
        fun(index,curr,sum + candidatesG[index]);
        curr.remove(curr.size()-1);
        fun(index + 1, curr,sum);
    }
}