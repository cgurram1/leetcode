class Solution {
    // public String fractionToDecimal(int num, int den) {
    //     long numerator = num;
    //     long denominator = den;
    //     boolean isNegative = false;
    //     if(numerator < 0 && denominator < 0){
    //     }
    //     else if(numerator < 0 || denominator < 0){
    //         isNegative = true;
    //         numerator = Math.abs(numerator);
    //         denominator = Math.abs(denominator);
    //     }
    //     long before = (long)(numerator / denominator);
    //     StringBuilder after = new StringBuilder();
    //     HashMap<Long,Integer> map = new HashMap<>();
    //     int index = 0;
    //     boolean roundDone = false;
    //     long check = numerator%denominator;
    //     while((check != 0 && roundDone == true) || check != 0){
    //         numerator = check*10;
    //         int afterValue = (int)(numerator / denominator);
    //         if(afterValue > 0){
    //             roundDone = true;
    //         }
    //         if(map.containsKey(numerator) && roundDone == true){
    //             after.insert(map.get(numerator),"(");
    //             after.append(")");
    //             break;
    //         }
    //         after.append(afterValue+"");
    //         map.putIfAbsent(numerator,index);
    //         index+=1;
    //         check = numerator%denominator;
    //     }
    //     if(after.length() == 0){
    //         if(isNegative == true && before != 0){
    //             return "-" + before;
    //         }
    //         return before + "";
    //     }
    //     if(isNegative == true){
    //         return "-" + before + "." + after.toString();
    //     }
    //     return before + "." + after.toString();
    // }
    public String fractionToDecimal(int num, int den) {
    long numerator   = num;
    long denominator = den;
    boolean negative = (numerator < 0) ^ (denominator < 0);   // XOR

    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);

    long integerPart = numerator / denominator;
    long remainder   = numerator % denominator;

    if(integerPart == 0 && remainder == 0){
        return "0";
    }
    if (remainder == 0)                       // terminates
        return (negative ? "-" : "") + integerPart;

    StringBuilder frac = new StringBuilder();
    Map<Long, Integer> seen = new HashMap<>();

    while (remainder != 0) {
        if (seen.containsKey(remainder)) {    // recurring cycle
            frac.insert(seen.get(remainder), "(");
            frac.append(')');
            break;
        }
        seen.put(remainder, frac.length());

        remainder *= 10;
        frac.append((char) ('0' + (remainder / denominator)));
        remainder %= denominator;             // <-- only ONE mod per loop
    }

    StringBuilder out = new StringBuilder();
    if (negative) out.append('-');
    out.append(integerPart).append('.').append(frac);
    return out.toString();
}

}