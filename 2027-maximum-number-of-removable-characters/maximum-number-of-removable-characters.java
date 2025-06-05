import java.util.*;

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = s.length();
        int rlen = removable.length;
        int[] removalTime = new int[n];
        for (int i = 0; i < rlen; i++) {
            removalTime[ removable[i] ] = i + 1;
        }
        int lo = 0, hi = rlen, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isSubsequenceAfterDeletion(s, p, removalTime, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean isSubsequenceAfterDeletion(String s, String p, int[] removalTime, int k) {
        int pj = 0;
        for (int si = 0; si < s.length() && pj < p.length(); si++) {
            if (removalTime[si] > 0 && removalTime[si] <= k) {
                continue;
            }
            if (s.charAt(si) == p.charAt(pj)) {
                pj++;
            }
        }
        return (pj == p.length());
    }
}
