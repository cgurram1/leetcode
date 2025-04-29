class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        fun(0,nums,new ArrayList<>(), result);
        return result;
    }
    public void fun(int index, int [] nums, List<Integer> path, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        fun(index + 1, nums,path,result);
        path.remove(path.size()-1);
        while(index + 1 < nums.length && nums[index + 1] == nums[index]){
            index += 1;
        }
        fun(index + 1, nums, path, result);
    }
}