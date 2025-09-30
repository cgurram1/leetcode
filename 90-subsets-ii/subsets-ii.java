class Solution {
    public List<List<Integer>> result;
    public int[] numsG;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        numsG = nums;
        Arrays.sort(numsG);
        fun(0,new ArrayList<>());
        return result;
    }
    public void fun(int index, List<Integer> curr){
        if(index >= numsG.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(numsG[index]);
        fun(index + 1, curr);
        curr.remove(curr.size()-1);
        while(index < numsG.length-1 && numsG[index] == numsG[index + 1]){
            index++;
        }
        fun(index + 1, curr);
    }
}