class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int productSum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            productSum+=(nums[i]*i);
        }
        // System.out.println(sum + " " + productSum);
        int res = productSum;
        int prevProductSum = productSum;
        for(int i = nums.length-1;i>=0;i--){
            res = Math.max(res, sum + prevProductSum - (nums.length * nums[i]));
            prevProductSum = sum + prevProductSum - (nums.length * nums[i]);
        }
        return res;
    }
}