class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{ newInterval };
        }

        int curr = 0;
        List<int[]> resultList = new ArrayList<>();

        // Add intervals that end before newInterval starts
        while (curr < intervals.length && newInterval[0] > intervals[curr][1]) {
            resultList.add(intervals[curr]);
            curr++;
        }

        // Merge all overlapping intervals
        while (curr < intervals.length && intervals[curr][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[curr][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[curr][1]);
            curr++;
        }

        // Add the merged interval
        resultList.add(newInterval);

        // Add the rest of the intervals
        while (curr < intervals.length) {
            resultList.add(intervals[curr]);
            curr++;
        }

        return resultList.toArray(new int[0][]);
    }
}
