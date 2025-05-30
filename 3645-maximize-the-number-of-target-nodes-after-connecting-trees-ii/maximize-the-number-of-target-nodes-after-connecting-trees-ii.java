import java.util.*;

public class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        // Build adjacency lists
        List<Integer>[] graph1 = buildGraph(edges1, n1);
        List<Integer>[] graph2 = buildGraph(edges2, n2);

        // Color tree1 and count how many nodes land on even levels
        boolean[] parity1 = new boolean[n1];
        int even1 = bfsColorAndCount(graph1, parity1);

        // Color tree2 and count how many nodes land on even levels
        boolean[] parity2 = new boolean[n2];
        int even2 = bfsColorAndCount(graph2, parity2);

        // Compute odd counts
        int odd1 = n1 - even1;
        int odd2 = n2 - even2;

        // For tree2 we can choose the connection to maximize targets,
        // so across all nodes in tree2 we take the larger of even2 or odd2.
        int max2 = Math.max(even2, odd2);

        // Build answer: for each node i in tree1, count how many in tree1
        // share its parity, then add max2.
        int[] answer = new int[n1];
        for (int i = 0; i < n1; i++) {
            int sameIn1 = parity1[i] ? even1 : odd1;
            answer[i] = sameIn1 + max2;
        }

        return answer;
    }

    // Helper to build an undirected graph from edge list
    private List<Integer>[] buildGraph(int[][] edges, int size) {
        List<Integer>[] graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return graph;
    }

    // BFS to assign parity (true=even level, false=odd) and count even-level nodes
    private int bfsColorAndCount(List<Integer>[] graph, boolean[] parity) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(0);
        visited[0] = true;
        parity[0] = true;  // root at level 0 is even
        int evenCount = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    parity[v] = !parity[u];
                    if (parity[v]) evenCount++;
                    queue.offer(v);
                }
            }
        }

        return evenCount;
    }
}
