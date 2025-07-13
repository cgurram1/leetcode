class Solution {
    public int findKthLargest(int[] nums, int k) {
        int [] arr = new int[2 * (int)Math.pow(10,4) + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]+(int)Math.pow(10,4)]+=1;
            max = Math.max(max,nums[i]+(int)Math.pow(10,4));
        }
        for(int i = max;i>=0;i--){
            k-=arr[i];
            if(k <= 0){
                return i-(int)Math.pow(10,4);
            }
        }
        return 0;
    }
}