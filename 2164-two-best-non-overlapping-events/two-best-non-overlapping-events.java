class Solution {

    public int bestPreviousEvent(int[][] events, int index, int [] maxSoFar){
        int startTime = events[index][0];
        int left = 0;
        int right = index - 1;
        int currMax = 0;
        while(left <= right){
            int mid = (left + right)/2;
            int prevEndTime = events[mid][1];
            if(prevEndTime >= startTime){
                right = mid - 1;
            }
            else{
                currMax = maxSoFar[mid];
                left = mid + 1;
            }
        }
        return currMax;
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)->{
            return a[1] - b[1];
        });
        int res = 0;
        int [] maxSoFar = new int[events.length];
        maxSoFar[0] = events[0][2];
        for(int i = 1;i<events.length;i++){
            maxSoFar[i] = Math.max(maxSoFar[i-1], events[i][2]);
        }
        for(int i = 0;i<events.length;i++){
            res = Math.max(res, bestPreviousEvent(events, i, maxSoFar) + events[i][2]);
        }
        return res;
    }
}