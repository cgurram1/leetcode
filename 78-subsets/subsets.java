class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        fun(0,new ArrayList<>(), result,nums);
        return result;
    }
    public void fun(int index, List<Integer> temp , List<List<Integer>> result, int [] nums){
        if(index == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        fun(index + 1, temp, result,nums);
        temp.remove(temp.size()-1);
        fun(index + 1, temp, result,nums);
    }
}