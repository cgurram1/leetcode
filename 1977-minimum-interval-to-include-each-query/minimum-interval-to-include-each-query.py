class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort(key=lambda x:[x[0],x[1]])
        queries = [(x,i) for i,x in enumerate(queries)]
        queries.sort()
        pq = []
        result = [-1 for _ in range(len(queries))]
        i = 0
        for query in queries:
            val,idx = query
            while i < len(intervals) and intervals[i][0] <= val:
                heapq.heappush(pq,(intervals[i][1] - intervals[i][0] + 1,intervals[i][1]))
                i+=1
            while pq and pq[0][1] < val:
                heapq.heappop(pq)
            if pq:
                result[idx] = pq[0][0]
        return result