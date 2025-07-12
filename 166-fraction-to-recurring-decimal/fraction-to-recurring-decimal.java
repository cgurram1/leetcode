class Solution {
    public String fractionToDecimal(int num, int den) {
        long numerator = num;
        long denominator = den;
        boolean isNegative = false;
        if(numerator < 0 && denominator < 0){
        }
        else if(numerator < 0 || denominator < 0){
            isNegative = true;
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        long before = (long)(numerator / denominator);
        StringBuilder after = new StringBuilder();
        HashMap<Long,Integer> map = new HashMap<>();
        int index = 0;
        boolean roundDone = false;
        while(((numerator % denominator) != 0 && roundDone == true) || (numerator % denominator) != 0){
            numerator = (numerator%denominator)*10;
            int afterValue = (int)(numerator / denominator);
            if(afterValue > 0){
                roundDone = true;
            }
            if(map.containsKey(numerator) && roundDone == true){
                after.insert(map.get(numerator),"(");
                after.append(")");
                break;
            }
            after.append(afterValue+"");
            map.putIfAbsent(numerator,index);
            index+=1;
        }
        if(after.length() == 0){
            if(isNegative == true && before != 0){
                return "-" + before;
            }
            return before + "";
        }
        if(isNegative == true){
            return "-" + before + "." + after.toString();
        }
        return before + "." + after.toString();
    }
}