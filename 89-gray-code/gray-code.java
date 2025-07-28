class Solution {
    public List<Integer> grayCode(int n) {
        int N = (int)Math.pow(2, n);
        boolean[] used = new boolean[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
            used[i] = true;
            if (rec(i, list, N, used)) {
                return list;
            }
            used[i] = false;
            list.remove(list.size() - 1);
        }
        return list;
    }

    public boolean rec(int prev, List<Integer> list, int N, boolean[] used) {
        if (list.size() == N) {
            int a = list.get(0), b = list.get(N - 1), diff = a ^ b;
            return diff != 0 && (diff & (diff - 1)) == 0;
        }
        // Only try flipping one bit at a time (n = log₂N)
        int bits = Integer.numberOfTrailingZeros(N);
        for (int bit = 0; bit < bits; bit++) {
            int cand = prev ^ (1 << bit);
            if (!used[cand]) {
                list.add(cand);
                used[cand] = true;
                if (rec(cand, list, N, used)) {
                    return true;
                }
                used[cand] = false;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
