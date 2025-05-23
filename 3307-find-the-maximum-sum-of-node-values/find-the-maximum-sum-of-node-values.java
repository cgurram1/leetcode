class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int [] delta = new int[nums.length];
        for (int i = 0;i<nums.length;i++) {
            sum += nums[i];
            delta[i] = (nums[i] ^ k) - nums[i];
        }
        // Sort descending without boxing
        Arrays.sort(delta);
        for (int i = 0; i < delta.length / 2; i++) {
            int temp = delta[i];
            delta[i] = delta[delta.length - 1 - i];
            delta[delta.length - 1 - i] = temp;
        }

        for (int i = 0; i + 1 < delta.length; i += 2) {
            if(delta[i] + delta[i+1] > 0){
                sum += (delta[i] + delta[i+1]);
            }
        }

        return sum;
    }
}
