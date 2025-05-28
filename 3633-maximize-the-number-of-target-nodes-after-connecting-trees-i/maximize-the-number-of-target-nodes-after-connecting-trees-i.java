class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        ArrayList<Integer> [] adjList2 = new ArrayList[edges2.length+1];
        for(int i = 0;i<adjList2.length;i++){
            adjList2[i] = new ArrayList<>();
        }
        for(int[] edge : edges2){
            adjList2[edge[0]].add(edge[1]);
            adjList2[edge[1]].add(edge[0]);
        }
        ArrayList<Integer> [] adjList1 = new ArrayList[edges1.length+1];
        for(int i = 0;i<adjList1.length;i++){
            adjList1[i] = new ArrayList<>();
        }
        for(int[] edge : edges1){
            adjList1[edge[0]].add(edge[1]);
            adjList1[edge[1]].add(edge[0]);
        }
        // for(int i = 0;i<adjList1.length;i++){
        //     // System.out.println(adjList1[i]);
        // }
        int [] result = new int[edges1.length + 1];
        int max = 0;
        for(int i = 0;i<edges2.length+1;i++){
            int val;
            if(k == 0){
                val = 0;
            }
            else{
                val = bfs(i,k-1,adjList2);
            }
            // System.out.println(i + " | " + val);
            max = Math.max(max,val);
        }
        // System.out.println("-------------------------");
        for(int i = 0;i<result.length;i++){
            int val = bfs(i,k,adjList1);
            // System.out.println(i + " | " + val);
            result[i] = val + max;
        }
        return result;
    }
    public int bfs(int node, int dist,ArrayList<Integer> [] adjList){
        int [] visited = new int[adjList.length];
        Arrays.fill(visited,-1);
        int result = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        visited[node] = 1;
        while(queue.size() > 1 && dist > 0){
            dist-=1;
            while(queue.peek() != null){
                int curr = queue.poll();
                for(int nextNode : adjList[curr]){
                    if(visited[nextNode] != 1){
                        result+=1;
                        queue.add(nextNode);
                        visited[nextNode] = 1;
                    }
                }
            }
            queue.add(queue.poll());
        }
        return result;
    }
}