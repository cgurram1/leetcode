class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int count = 0;
        boolean[] visited = new boolean[n * n + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(null);
        visited[1] = true;

        while (queue.size() > 1) {
            while (queue.peek() != null) {
                int position = queue.poll();
                if (position == n * n) {
                    return count;
                }
                for (int i = 1; i <= 6; i++) {
                    int nextPos = position + i;
                    if (nextPos > n * n) {
                        break;
                    }
                    int[] arr = getCoordinates(nextPos, n);
                    int x = arr[0], y = arr[1];
                    if (board[x][y] != -1) {
                        nextPos = board[x][y];
                    }
                    if (!visited[nextPos]) {
                        visited[nextPos] = true;
                        queue.add(nextPos);
                    }
                }
            }
            queue.poll();
            queue.add(null);
            count++;
        }
        return -1;
    }
    private int[] getCoordinates(int num, int n) {
        int quot = (num - 1) / n;
        int row = n - 1 - quot;
        int rem = (num - 1) % n;
        int col;
        if (quot % 2 == 0) {
            col = rem;
        } else {
            col = n - 1 - rem;
        }
        return new int[]{row, col};
    }
}
