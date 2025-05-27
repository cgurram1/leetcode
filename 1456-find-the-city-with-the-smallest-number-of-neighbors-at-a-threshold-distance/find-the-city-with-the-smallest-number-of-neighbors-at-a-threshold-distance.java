class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] distances = new int[n][n];
        for(int [] dist : distances){
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        for(int i = 0;i<n;i++){
            distances[i][i] = 0;
        }
        for(int [] edge : edges){
            distances[edge[0]][edge[1]] = edge[2];
            distances[edge[1]][edge[0]] = edge[2];
        }
        for(int via = 0;via < n;via++){
            for(int src = 0;src<n;src++){
                for(int target = 0;target< n;target++){
                    if(distances[src][via] != Integer.MAX_VALUE && distances[via][target] != Integer.MAX_VALUE){
                        distances[src][target] = Math.min(distances[src][target], distances[src][via] + distances[via][target]);
                    }
                }
            }
        }
        int temp = 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int city = 0;city<n;city++){
            temp = 0;
            for(int anotherCity = 0;anotherCity < n;anotherCity++){
                if(city != anotherCity && distances[city][anotherCity] <= distanceThreshold){
                    temp+=1;
                }
            }
            if(temp <= min){
                min = temp;
                result = city;
            }
        }
        return result;
    }
}