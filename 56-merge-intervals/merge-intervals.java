class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return new int[][]{intervals[0]};
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int i = 1;
        ArrayList<int []> result = new ArrayList<>();
        int [] prev = intervals[i-1];
        int [] curr = intervals[i];
        boolean isLast = false;
        while(i < intervals.length){
            curr = intervals[i];
            if(prev[1] < curr[0]){
                result.add(new int[]{prev[0],prev[1]});
                prev = curr;
                isLast = true;
            }
            else{
                prev = new int[]{Math.min(prev[0],curr[0]),Math.max(prev[1],curr[1])};
                isLast = false;
            }
            i++;
        }
        if(isLast){
            result.add(curr);
        }
        else{
            result.add(prev);
        }
        int [][] res = new int[result.size()][2];
        int j = 0;
        for(int [] ar : result){
            System.out.println(Arrays.toString(ar));
            res[j] = ar;
            j++;
        }
        return res;
    }
}