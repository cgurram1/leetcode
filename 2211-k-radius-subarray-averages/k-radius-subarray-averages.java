class Solution {
    public int[] getAverages(int[] nums, int k) {
        int [] result = new int[nums.length];
        Arrays.fill(result, -1);
        if(2*k >= nums.length){
            return result;
        }
        long sum = 0;
        for(int i = 0;i<=2*k;i++){
            sum+=nums[i];
        }
        result[k] = (int)(sum/(2*k+1));
        int left = 0;
        int right = 2*k;
        int i = k+1;
        while(i < nums.length - k){
            sum += nums[right+1];
            sum-=nums[left];
            right+=1;
            left+=1;
            result[i] = (int)(sum/(2*k+1));
            i++;
        }
        return result;
    }
}