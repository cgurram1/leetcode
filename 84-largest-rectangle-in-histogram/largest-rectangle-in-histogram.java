class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] nextMin = new int[heights.length];
        int [] prevMin = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        //prev min
        for(int i = 0;i<heights.length;i++){
            while(stack.isEmpty() == false && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                prevMin[i] = -1;
            }
            else{
                prevMin[i] = stack.peek();
            }
            stack.push(i);
        }
        // next min
        stack.clear();
        for(int i = heights.length-1;i>=0;i--){
            while(stack.isEmpty() == false && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                nextMin[i] = heights.length;
            }
            else{
                nextMin[i] = stack.peek();
            }
            stack.push(i);
        }
        int res = 0;
        // System.out.println(Arrays.toString(prevMin));
        // System.out.println(Arrays.toString(nextMin));
        for(int i = 0;i<heights.length;i++){
            res = Math.max(res,heights[i] * ((i - prevMin[i]) + (nextMin[i] - i)-1));
        }
        return res;
    }   
}