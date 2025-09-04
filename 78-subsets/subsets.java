class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int [] numsG;
    public List<List<Integer>> subsets(int[] nums) {
        numsG = nums;
        fun(0,new ArrayList<>());
        return result;
    }
    public void fun(int index,List<Integer> curr){
        if(index == numsG.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(numsG[index]);
        fun(index + 1, curr);
        curr.remove(curr.size()-1);
        fun(index + 1, curr);
    }
}