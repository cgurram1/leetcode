class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        
        // Count frequencies
        for (char task : tasks) {
            freqs[task - 'A']++;
        }

        // Add initial tasks to the priority queue
        for (int i = 0; i < 26; i++) {
            if (freqs[i] > 0) {
                pq.add(new Pair((char)(i + 'A'), freqs[i]));
            }
        }

        int res = 0;
        while (!pq.isEmpty()) {
            List<Pair> temp = new ArrayList<>();
            int cycle = n + 1;

            // Try to schedule up to n + 1 tasks
            while (cycle > 0 && !pq.isEmpty()) {
                Pair p = pq.poll();
                p.freq--;
                if (p.freq > 0) {
                    temp.add(p); // store for next round
                }
                res++;
                cycle--;
            }

            // Re-add remaining tasks
            for (Pair p : temp) {
                pq.add(p);
            }

            // If there are still tasks left, we had idle time
            if (!pq.isEmpty()) {
                res += cycle;
            }
        }

        return res;
    }
}

class Pair {
    char ch;
    int freq;
    public Pair(char c, int f) {
        this.ch = c;
        this.freq = f;
    }
}
