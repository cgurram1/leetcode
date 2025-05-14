class Solution {
    public int [][] graph;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        int [] visited = new int[graph.length];
        Arrays.fill(visited,-1);
        List<Integer> safe = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            if(dfs(i,visited)){
                safe.add(i);
            }
        }
        return safe;
    }
    public boolean dfs(int node,int [] visited){
        if(visited[node] == 1){
            return false;
        }
        if(visited[node] == 2){
            return true;
        }
        visited[node] = 1;
        for(int i = 0;i<graph[node].length;i++){
            if(!dfs(graph[node][i],visited)){
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}