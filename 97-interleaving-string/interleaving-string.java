class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return fun(0, 0, s1, s2, s3, memo);
    }

    public boolean fun(int i1, int i2, String s1, String s2, String s3, Boolean[][] memo) {
        if (i1 + i2 == s3.length()) return true;

        if (memo[i1][i2] != null) return memo[i1][i2];

        boolean pickLeft = false, pickRight = false;

        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2)) {
            pickLeft = fun(i1 + 1, i2, s1, s2, s3, memo);
        }

        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2)) {
            pickRight = fun(i1, i2 + 1, s1, s2, s3, memo);
        }

        return memo[i1][i2] = pickLeft || pickRight;
    }
}
