class Solution {
    public int myAtoi(String s) {
        boolean isNegative = false;
        boolean isFirstDigitFound = false;
        boolean isSignFound = false;
        double num = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '-' && isFirstDigitFound == false && isSignFound == false){
                isNegative = true;
                isSignFound = true;
            }
            else if((s.charAt(i) == ' ' && isFirstDigitFound == false && isSignFound == false) || (s.charAt(i) == '+' && isFirstDigitFound == false && isSignFound == false)){
                if(s.charAt(i) == '+'){
                    isSignFound = true;
                }
            }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                isFirstDigitFound = true;
                num = num*10 + (s.charAt(i) - '0');
                if(num > Integer.MAX_VALUE){
                    return isNegative == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            else{
                break;
            }
        }
        // if((int)num != num){
        //     if(isNegative){
        //         return Integer.MIN_VALUE;
        //     }
        //     else{
        //         return Integer.MAX_VALUE;
        //     }
        // }
        if(isNegative){
            return -(int)num;
        }
        return (int)num;
    }
}