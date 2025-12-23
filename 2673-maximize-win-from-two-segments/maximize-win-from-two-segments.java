class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] best = new int[n + 1];

        int left = 0;

        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }

            int windowSize = right - left + 1;
            best[right + 1] = Math.max(best[right], windowSize);
        }

        int ans = 0;
        left = 0;

        for (int right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }

            int windowSize = right - left + 1;
            ans = Math.max(ans, windowSize + best[left]);
        }

        return ans;
    }
}
