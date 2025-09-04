class Solution {
    int[] candidatesG;
    int targetG;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        candidatesG = candidates;
        targetG = target;
        Arrays.sort(candidatesG);
        fun(0,0,new ArrayList<>());
        return result;
    }
    public void fun(int index, int sum, List<Integer> curr){
        if(sum == targetG){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum > targetG){
            return;
        }
        for(int i = index; i < candidatesG.length;i++){
            if(i > index && candidatesG[i] == candidatesG[i-1]){
                continue;
            }
            curr.add(candidatesG[i]);
            fun(i + 1, sum + candidatesG[i], curr);
            curr.remove(curr.size()-1);
        }
    }
}