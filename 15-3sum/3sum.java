class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++){
            int left = i + 1;
            int right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(left < right){
                if(nums[left] + nums[right] == -1 * nums[i]){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] < -1 * nums[i]){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}