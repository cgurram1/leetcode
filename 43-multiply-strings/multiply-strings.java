class Solution {
    public String multiply(String num1, String num2) {
        List<Queue<Integer>> list = new ArrayList<>();
        int carry;
        for(int i = num2.length()-1;i>=0;i--){
            carry = 0;
            Queue<Integer> line = new LinkedList<>();
            int k = i;
            while(k < num2.length()-1){
                line.add(0);
                k++;
            }
            for(int j = num1.length()-1;j>=0;j--){
                int num = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
                carry = num/10;
                num = num%10;
                line.add(num);
            }
            line.add(carry);
            list.add(new LinkedList<>(line));
        }
        Stack<Integer> result = new Stack<>();
        carry = 0;
        while(list.get(list.size()-1).isEmpty() == false){
            int sum = 0;
            for(int i = 0;i<list.size();i++){
                if(list.get(i).isEmpty() == false){
                    sum+=list.get(i).poll();
                }
            }
            sum+=carry;
            carry = sum/10;
            sum = sum % 10;
            result.push(sum);
        }
        StringBuilder str = new StringBuilder(result.size());
        int zeros = 0;
        while(result.isEmpty() == false){
            str.append(result.pop());
        }
        int firstNonZero = 0;
        boolean foundFirstNonZero = false;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) > '0' && str.charAt(i) <= '9'){
                firstNonZero = i;
                foundFirstNonZero = true;
                break;
            }
        }
        if(foundFirstNonZero == false){
            return "0";
        }
        return str.toString().substring(firstNonZero, str.length());
    }
}