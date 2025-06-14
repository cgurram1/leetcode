class Solution {
    public int minMaxDifference(int num) {
        Stack<Integer> stack = new Stack<>();
        int temp = num;
        while(temp > 0){
            stack.push(temp % 10);
            temp = temp / 10;
        }
        int val = -1; 
        int maxNum = 0;
        int val1 = -1;
        int minNum = 0;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(curr < 9){
                if(val == -1){
                    val = curr;
                }
            }
            if(curr == val){
                maxNum = maxNum * 10 + 9;
            }
            else{
                maxNum = maxNum * 10 + curr;
            }
            if(curr > 0){
                if(val1 == -1){
                    val1 = curr;
                }
            }
            if(curr == val1){
                minNum = minNum * 10;
            }
            else{
                minNum = minNum * 10 + curr;
            }
        }
        // System.out.println(maxNum + " " + minNum);
        return maxNum - minNum;
    }
}