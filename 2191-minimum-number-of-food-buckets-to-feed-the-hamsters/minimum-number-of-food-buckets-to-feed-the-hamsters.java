class Solution {
    public int minimumBuckets(String hamsters1) {
        int res = 0;
        StringBuilder hamsters = new StringBuilder(hamsters1);
        for (int i = 0; i < hamsters.length(); i++) {
            if (hamsters.charAt(i) == 'H') {
                if (i > 0 && hamsters.charAt(i - 1) == 'B') {
                    continue;
                }
                if (i + 1 < hamsters.length() && hamsters.charAt(i + 1) == '.') {
                    hamsters.setCharAt(i + 1, 'B');
                    res++;
                }
                else if (i > 0 && hamsters.charAt(i - 1) == '.') {
                    hamsters.setCharAt(i - 1, 'B');
                    res++;
                }
                else {
                    return -1;
                }
            }
        }
        return res;
    }
}