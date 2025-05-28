class Solution {
    public int maxSumMinProduct(int[] nums) {
        long [] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        // for(int i = 0;i<nums.length;i++){
        //     System.out.print(prefixSum[i]);
        // }
        // System.out.println();
        int [] prevMin = new int[nums.length];
        int [] nextMin = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prevMin[i] = -1;
            }
            else{
                prevMin[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextMin[i] = nums.length;
            }
            else{
                nextMin[i] = stack.peek();
            }
            stack.push(i);
        }
        // for(int i = 0;i<nums.length;i++){
        //     System.out.print(prevMin[i] + " ");
        // }
        // System.out.println("");
        // for(int i = 0;i<nums.length;i++){
        //     System.out.print(nextMin[i] + " ");
        // }
        // System.out.println("");
        long max = 0;
        for(int i = 0;i<nums.length;i++){
            if(prevMin[i] == -1){
                max = Math.max(nums[i] * prefixSum[nextMin[i] - 1], max);
            }
            else{
                max = Math.max(nums[i] * (prefixSum[nextMin[i] - 1] - prefixSum[prevMin[i]]), max);
            }
        }
        int MOD = 1_000_000_007;
        return (int)(max % MOD);
    }
}