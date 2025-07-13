class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        Arrays.sort(intervals, (a,b) -> {
            return a[1] - b[1];
        });
        // for(int [] arr : intervals){
        //     System.out.println(arr[0] + "" + arr[1]);
        // }
        int [] lastMeeting = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] >= lastMeeting[1]){
                lastMeeting = intervals[i];
                count+=1;
            }
        }
        return intervals.length - count;
    }
}