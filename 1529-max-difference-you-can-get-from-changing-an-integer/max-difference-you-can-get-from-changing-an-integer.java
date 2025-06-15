class Solution {
    public int maxDiff(int num) {
        Stack<Integer> stack = new Stack<>();
        int temp = num;
        int val1 = -1;
        int val2 = -1;
        int dummyVal = -1;
        int isLastOne = 0;
        while(temp > 0){
            int curr = temp % 10;
            if(curr < 9){
                val1 = curr;
            }
            if(curr > 0 && val2 != curr){
                dummyVal = val2;
                val2 = curr;
            }
            stack.push(curr);
            temp = temp / 10;
            if(temp < 9 && temp == 1){
                isLastOne = 1;
            }
        }
        int num1 = 0;
        int num2 = 0;
        while(!stack.isEmpty()){
            int currNum = stack.pop();
            if(currNum == val1){
                num1 = num1 * 10 + 9;
            }
            else{
                num1 = num1 * 10 + currNum;
            }
            if(isLastOne == 1){
                if(currNum == dummyVal){
                    num2 = num2 * 10 + 0;
                }
                else{
                    num2 = num2 * 10 + currNum;
                }
            }
            else{
                if(currNum == val2){
                    num2 = num2 * 10 + 1;
                }
                else{
                    num2 = num2 * 10 + currNum;
                }
            }
        }
        // System.out.println(num1  + " " + num2);
        return num1 - num2;
    }
}