class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        // Step 1: Calculate distances from node1 and node2
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        // Fill distance from node1
        fillDistances(edges, node1, dist1);

        // Fill distance from node2
        fillDistances(edges, node2, dist2);

        // Step 2: Find the node reachable from both with minimum max(dist1, dist2)
        int minDistance = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    result = i;
                } else if (maxDist == minDistance && i < result) {
                    result = i;
                }
            }
        }

        return result;
    }

    private void fillDistances(int[] edges, int startNode, int[] dist) {
        int distance = 0;
        boolean[] visited = new boolean[edges.length];
        int current = startNode;

        while (current != -1 && !visited[current]) {
            dist[current] = distance;
            visited[current] = true;
            current = edges[current];
            distance++;
        }
    }
}
