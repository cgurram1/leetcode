class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 0;i<nums.length;i++){
            curr+=nums[i];
            min = Math.min(min,curr);
        }
        if(min < 0){
            return (-1 * min) + 1;
        }
        return 1;
    }
}