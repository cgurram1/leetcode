class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<asteroids.length;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
            }
            else{
                if(asteroids[i] < 0){
                    while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -1*asteroids[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty() && stack.peek() == -1 * asteroids[i]){
                        stack.pop();
                    }
                    else if(stack.isEmpty() || stack.peek() < 0){
                        stack.push(asteroids[i]);
                    }
                }
                else{
                    stack.push(asteroids[i]);
                }
            }
        }
        // System.out.println(stack);
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.get(i);
        }
        return arr;
    }
}