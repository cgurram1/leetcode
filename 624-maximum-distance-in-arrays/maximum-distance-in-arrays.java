class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int [][] maxes = new int[2][2];
        for(int [] arr : maxes){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        int [][] mins = new int[2][2];
        for(int [] arr : mins){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int i = 0;i<arrays.size();i++){
            if(arrays.get(i).get(0) < mins[0][0]){
                mins[1][0] = mins[0][0];
                mins[1][1] = mins[0][1];
                mins[0][0] = arrays.get(i).get(0);
                mins[0][1] = i;
            }
            else if(arrays.get(i).get(0) < mins[1][0]){
                mins[1][0] = arrays.get(i).get(0);
                mins[1][1] = i;
            }
        }
        for(int i = 0;i<arrays.size();i++){
            if(arrays.get(i).get(arrays.get(i).size()-1) > maxes[0][0]){
                maxes[1][0] = maxes[0][0];
                maxes[1][1] = maxes[0][1];
                maxes[0][0] = arrays.get(i).get(arrays.get(i).size()-1);
                maxes[0][1] = i;
            }
            else if(arrays.get(i).get(arrays.get(i).size()-1) > maxes[1][0]){
                maxes[1][0] = arrays.get(i).get(arrays.get(i).size()-1);
                maxes[1][1] = i;
            }
        }
        int max = 0;
        if(mins[0][1] != maxes[0][1]){
            max = Math.max(max,maxes[0][0] - mins[0][0]);
        }
        if(mins[0][1] != maxes[1][1]){
            max = Math.max(max,maxes[1][0] - mins[0][0]);
        }
        if(mins[1][1] != maxes[0][1]){
            max = Math.max(max,maxes[0][0] - mins[1][0]);
        }
        if(mins[1][1] != maxes[1][1]){
            max = Math.max(max,maxes[1][0] - mins[1][0]);
        }

        return max;
    }
}