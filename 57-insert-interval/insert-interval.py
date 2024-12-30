class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if len(intervals) == 0:
            intervals.append(newInterval)
            return intervals
        
        i = 0
        while(i < len(intervals) and intervals[i][0] <= newInterval[0]):
            i+=1
        intervals.insert(i,newInterval)
        res = [intervals[0]]
        for interval in intervals[1:]:
            first = res[-1]
            second = interval
            if first[1] < second[0]:
                res.append(interval)
            else:
                res.pop(-1)
                res.append([min(first[0],second[0]),max(first[1],second[1])])
        return res