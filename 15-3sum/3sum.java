class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        Arrays.sort(nums);
        List<Integer> curr;
        while(i < nums.length - 2){
            if(nums[i] > 0){
                break;
            }
            int j = i + 1;
            int k = nums.length-1;
            while(j < k){
                if(nums[j] + nums[k] == -1* nums[i]){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j+1] == nums[j]){
                        j+=1;
                    }
                    j+=1;
                    while(k > j && nums[k-1] == nums[k]){
                        k-=1;
                    }
                    k-=1;
                }
                else if(nums[j] + nums[k] > -1* nums[i]){
                    while(k > j && nums[k-1] == nums[k]){
                        k-=1;
                    }
                    k-=1;
                }
                else{
                    while(j < k && nums[j+1] == nums[j]){
                        j+=1;
                    }
                    j+=1;
                }
            }
            while(i < nums.length - 2 && nums[i+1] == nums[i]){
                i+=1;
            }
            i+=1;
        }
        return result;
    }
}