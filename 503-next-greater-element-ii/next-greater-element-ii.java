class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int[nums.length];
        int [] newArray = new int[nums.length*2];
        for(int i = 0;i<nums.length;i++){
            newArray[i] = nums[i];
        }
        for(int i = nums.length;i<2*nums.length;i++){
            newArray[i] = nums[i-nums.length];
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*nums.length-1;i>=nums.length;i--){
            if(stack.isEmpty()){
                stack.push(newArray[i]);
            }
            while(stack.isEmpty() == false && newArray[i] >= stack.peek()){
                stack.pop();
            }
            stack.push(newArray[i]);
        }
        for(int i = nums.length-1;i>=0;i--){
            while(stack.isEmpty() == false && nums[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}