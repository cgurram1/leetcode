class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len-1;
        while(i > 0 && nums[i-1] >= nums[i]){
            i-=1;
        }
        if(i == 0){
            Arrays.sort(nums);
            return;
        }
        int numToSwapIndex = len-1;
        while(numToSwapIndex >= 0 && nums[numToSwapIndex] <= nums[i-1]){
            numToSwapIndex-=1;
        }
        if(numToSwapIndex < 0){
            Arrays.sort(nums);
            return;
        }
        int temp = nums[i-1];
        nums[i-1] = nums[numToSwapIndex];
        nums[numToSwapIndex] = temp;
        int left = i;
        int right = len;
        Arrays.sort(nums, left, right);
    }
}