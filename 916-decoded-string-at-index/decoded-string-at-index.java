class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        // 1. Forward pass: compute decoded size
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }

        // 2. Backward pass: find k-th character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                long d = c - '0';
                size /= d;
                k %= size;
                if (k == 0) k = (int) size;
            } else {
                if (k == size) {
                    return String.valueOf(c);
                }
                size--;
            }
        }

        return "";
    }
}
