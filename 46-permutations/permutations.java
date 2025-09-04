class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int [] numsG;
    public List<List<Integer>> permute(int[] nums) {
        numsG = nums;
        fun(0,new HashSet<>(), new ArrayList<>());
        return result;
    }
    public void fun(int level, Set<Integer> set, List<Integer> curr){
        if(level == numsG.length){
            result.add(new ArrayList<>(curr));
        }
        for(int i = 0;i<numsG.length;i++){
            if(set.contains(numsG[i]) == false){
                set.add(numsG[i]);
                curr.add(numsG[i]);
                fun(level + 1,set,curr);
                set.remove(numsG[i]);
                curr.remove(curr.size()-1);
            }
        }
    }
}