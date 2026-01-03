class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> waitingQueue = new LinkedList<>();

        int[] freqs = new int[26];
        for (char task : tasks) {
            freqs[task - 'A']++;
        }

        for (int f : freqs) {
            if (f > 0) pq.add(f);
        }

        int time = 0;

        while (!pq.isEmpty() || !waitingQueue.isEmpty()) {

            while (!waitingQueue.isEmpty() &&
                   waitingQueue.peek().timeAvailableAt == time) {
                pq.add(waitingQueue.poll().freq);
            }

            if (!pq.isEmpty()) {
                int curr = pq.poll();
                if (curr - 1 > 0) {
                    waitingQueue.add(new Pair(curr - 1, time + n + 1));
                }
            }

            time++;
        }
        return time;
    }
}

class Pair {
    int freq;
    int timeAvailableAt;

    Pair(int freq, int timeAvailableAt) {
        this.freq = freq;
        this.timeAvailableAt = timeAvailableAt;
    }
}
