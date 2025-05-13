class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        int result = s.length();
        int MOD = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int k = 0; k < t; k++) {
            int[] newFreq = new int[26];
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    if (i == 25) {
                        newFreq[0] = (int)(((long)newFreq[0] + freq[i]) % MOD);
                        newFreq[1] = (int)(((long)newFreq[1] + freq[i]) % MOD);
                        result = (int)(((long)result + freq[i]) % MOD);
                    } else {
                        newFreq[i + 1] = (int)(((long)newFreq[i + 1] + freq[i]) % MOD);
                    }
                }
            }
            freq = newFreq;
        }

        return result;
    }
}
