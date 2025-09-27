class Solution {
    public List<List<Integer>> result;
    public int targetG;
    public int [] candidatesG;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        targetG = target;
        Arrays.sort(candidates);
        candidatesG = candidates;
        fun(0,new ArrayList<>(),0);
        return result;
    }
    public void fun(int index, List<Integer> curr, int sum){
        if(sum == targetG){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum > targetG || index == candidatesG.length){
            return;
        }
        curr.add(candidatesG[index]);
        fun(index + 1, curr, sum + candidatesG[index]);
        while(index + 1 < candidatesG.length && candidatesG[index] == candidatesG[index + 1]){
            index++;
        }
        curr.remove(curr.size()-1);
        fun(index + 1,curr,sum);
    }
}