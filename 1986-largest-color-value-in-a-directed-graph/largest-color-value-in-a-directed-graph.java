class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        ArrayList<Integer> [] edgeList = new ArrayList[colors.length()];
        for(int i = 0;i<colors.length();i++){
            edgeList[i] = new ArrayList<>();
        }   
        for(int i = 0;i<edges.length;i++){
            edgeList[edges[i][0]].add(edges[i][1]);
        }
        int max = 0;
        int [] visited = new int[colors.length()];
        Arrays.fill(visited,0);
        int [] path = new int[colors.length()];
        Arrays.fill(path,0);
        int [][] memory = new int[colors.length()][26];
        for(int i = 0;i<colors.length();i++){
            if(dfs(i,memory,visited,path,edgeList,colors) == -1){
                return -1;
            }
        }
        for(int i = 0;i<colors.length();i++){
            for(int j = 0;j<26;j++){
                max = Math.max(max,memory[i][j]);
            }
        }
        return max;
    }
    public int dfs(int node,int [][] memory,int [] visited,int [] path,ArrayList<Integer> [] edgeList,String colors){
        visited[node] = 1;
        path[node] = 1;
        int [] colorCount = new int[26];
        for(int nextNode : edgeList[node]){
            if(path[nextNode] == 1){
                return -1;
            }
            else{
                if(visited[nextNode] == 0){
                    if(dfs(nextNode,memory,visited,path,edgeList,colors) == -1){
                        return -1;
                    }
                }
            }
            for(int i = 0;i<26;i++){
                colorCount[i] = Math.max(colorCount[i],memory[nextNode][i]);
            }
        }
        colorCount[colors.charAt(node) - 'a']+=1;
        memory[node] = colorCount;
        path[node] = 0;
        return 0;
    }
}