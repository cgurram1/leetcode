class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator  == 0){
            return "0";
        }
        boolean negative = (numerator < 0) ^ (denominator < 0);
        // Convert to long to handle overflow
        long num = (long) numerator;
        long den = (long) denominator;
        if(num < 0){
            num *=-1;
        }
        if(den < 0){
            den *= -1;
        }
        Map<Long,Integer> remainders = new HashMap<>();
        String integralPart;
        StringBuilder decimalPart = new StringBuilder();
        integralPart = (num/den) + "";
        long remainder = num%den;
        if(remainder == 0){
            if(negative){
                return "-"+integralPart;
            }
            return integralPart;
        }
        remainders.put(remainder,0);
        while(remainder != 0){
            long newNumber = remainder * 10;
            remainder = newNumber%den;
            decimalPart.append(newNumber/den);
            if(remainders.containsKey(remainder)){
                decimalPart.insert(remainders.get(remainder),"(");
                decimalPart.append(")");
                break;
            }
            remainders.put(remainder,decimalPart.length());
        }
        if(negative){
            return "-" + integralPart + "." + decimalPart.toString();
        }
        return integralPart + "." + decimalPart.toString();
    }
}