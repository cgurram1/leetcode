class Solution {
    public int minimumLength(String s) {
        char[] a = s.toCharArray();
        int l = 0, r = a.length - 1;
        while (l < r && a[l] == a[r]) {
            char c = a[l];
            while (l <= r && a[l] == c) l++;
            while (l <= r && a[r] == c) r--;
        }
        return r - l + 1;
    }
}