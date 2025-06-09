class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        int i = 1;
        while (i < k) {
            int steps = count(curr, n);
            if (i + steps <= k) {
                curr += 1;
                i += steps;
            } else {
                curr *= 10;
                i += 1;
            }
        }
        return curr;
    }

    public int count(long curr, long n) {
        long steps = 0, next = curr + 1;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return (int) steps;
    }
}
