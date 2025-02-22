class Solution {
    public long subArrayRanges(int[] nums) {
        long [] nextGreater = new long[nums.length];
        long [] prevGreater = new long[nums.length];
        long [] nextSmaller = new long[nums.length];
        long [] prevSmaller = new long[nums.length];

        Stack<Integer> stack = new Stack<>();
        // prevGreater
        for(int i = 0;i<nums.length;i++){
            while(stack.size() > 0 && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prevGreater[i] = -1;
            }
            else{
                prevGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        // nextGreater
        stack.clear();
        for(int i = nums.length-1;i>=0;i--){
            while(stack.size() > 0 && nums[i] > nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreater[i] = nums.length;
            }
            else{
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        // prevSmaller
        stack.clear();
        for(int i = 0;i<nums.length;i++){
            while(stack.size() > 0 && nums[i] <= nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prevSmaller[i] = -1;
            }
            else{
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        // nextSmaller
        stack.clear();
        for(int i = nums.length-1;i>=0;i--){
            while(stack.size() > 0 && nums[i] < nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextSmaller[i] = nums.length;
            }
            else{
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        long greaterRanges = 0;
        long smallerRanges = 0;
        for(int i = 0;i<nums.length;i++){
            greaterRanges += (nextGreater[i] - i) * (i - prevGreater[i]) * nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            smallerRanges += (nextSmaller[i] - i) * (i - prevSmaller[i]) * nums[i];
        }
        return greaterRanges - smallerRanges;
    }
}