class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<edges.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            adjList.get(edges[i][0]-1).add(edges[i][1]-1);
            adjList.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        for(int i = edges.length-1;i>=0;i--){
            if(hasCycle(adjList, new int[]{edges[i][0]-1, edges[i][1]-1}) == false){
                return edges[i];
            }
        }
        // System.out.println(adjList);
        return new int[]{-1,-1};
    }
    public boolean hasCycle(ArrayList<ArrayList<Integer>> adjList, int[] skipEdge) {
    int n = adjList.size();
    int[] visited = new int[n];
    int[] parent = new int[n];
    Arrays.fill(parent, -1);

    for (int start = 0; start < n; start++) {
        if (visited[start] == 1) continue;

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adjList.get(curr)) {
                if ((curr == skipEdge[0] && next == skipEdge[1]) || 
                    (next == skipEdge[0] && curr == skipEdge[1])) {
                    continue; // skip the edge we are testing
                }

                if (visited[next] == 1 && parent[curr] != next) {
                    return true; // cycle found
                }

                if (visited[next] == 0) {
                    visited[next] = 1;
                    parent[next] = curr;
                    queue.add(next);
                }
            }
        }
    }

    return false; // no cycle in any component
}

    
}