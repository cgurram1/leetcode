class Solution {
    public int maxDistance(String s, int k) {
        int maxDist = 0;
        int countN = 0, countS = 0, countE = 0, countW = 0;

        for (int i = 0; i < s.length(); i++) {
            char move = s.charAt(i);
            if (move == 'N') {
                countN++;
            } else if (move == 'S') {
                countS++;
            } else if (move == 'E') {
                countE++;
            } else {
                countW++;
            }
            int L = i + 1;
            int minPairs = Math.min(countN, countS) + Math.min(countE, countW);

            int currentDist;
            if (k >= minPairs) {
                currentDist = L;
            } else {
                int base = L - 2 * minPairs;
                currentDist = base + 2 * k;
            }
            maxDist = Math.max(maxDist, currentDist);
        }
        return maxDist;
    }
}
