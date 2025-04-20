class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, j);
                if (!isValid(s1) || !isValid(s2)) continue;
                if (dfs(new java.math.BigInteger(s1), new java.math.BigInteger(s2), j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(String s) {
        return !(s.length() > 1 && s.charAt(0) == '0');
    }
    private boolean dfs(java.math.BigInteger num1, java.math.BigInteger num2, int start, String num) {
        if (start == num.length()) return true;

        java.math.BigInteger sum = num1.add(num2);
        String sumStr = sum.toString();

        if (!num.startsWith(sumStr, start)) return false;

        return dfs(num2, sum, start + sumStr.length(), num);
    }
}