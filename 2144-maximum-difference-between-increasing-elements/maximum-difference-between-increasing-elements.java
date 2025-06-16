class Solution {
    public int maximumDifference(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int result = -1;
        for(int i = 0;i<nums.length;i++){
            while(!stack.isEmpty() && stack.peek() >= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result = Math.max(result,nums[i] - stack.peek());
            }
            else{
                stack.push(nums[i]);
            }
        }
        return result;
    }
}