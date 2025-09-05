class Solution {
    int[] result;
    List<List<Integer>> adjList;
    int N;
    public int[] gardenNoAdj(int n, int[][] paths) {
        result = new int[n];
        adjList = new ArrayList<>();
        N = n;
        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<paths.length;i++){
            adjList.get(paths[i][0]-1).add(paths[i][1]-1);
            adjList.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        fun(0);
        return result;
    }
    public boolean fun(int currNode){
        if(currNode == N){
            return true;
        }
        for(int i = 1;i<=4;i++){
            if(canPut(i,currNode)){
                result[currNode] = i;
                if(fun(currNode+1) == true){
                    return true;
                }
            }
        }
        return true;
    }
    public boolean canPut(int flower, int currNode){
        for(int nextNode : adjList.get(currNode)){
            if(result[nextNode] == flower){
                return false;
            }
        }
        return true;
    }
}