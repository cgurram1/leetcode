class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        rec(0,result,list,nums);
        return result;
    }
    public void rec(int index, List<List<Integer>> result,List<Integer> list, int [] nums){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        rec(index + 1, result, list,nums);
        list.remove(list.size()-1);
        rec(index + 1,result,list,nums);
    }
}