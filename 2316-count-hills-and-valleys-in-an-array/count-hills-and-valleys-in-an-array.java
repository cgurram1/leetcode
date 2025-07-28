class Solution {
    public int countHillValley(int[] nums) {
        int i = 1;
        int count = 0;
        while(i < nums.length-1){
            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && nums[left] == nums[i]){
                left-=1;
            }
            while(right < nums.length && nums[right] == nums[i]){
                right+=1;
            }
            if(left >= 0 && right < nums.length && nums[left] < nums[i] && nums[right] < nums[i]){
                count+=1;
            }
            else if(left >= 0 && right < nums.length && nums[left] > nums[i] && nums[right] > nums[i]){
                count+=1;
            }
            i = right;
        }
        return count;
    }
}