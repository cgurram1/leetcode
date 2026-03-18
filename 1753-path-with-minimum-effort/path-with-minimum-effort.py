class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        pq = []
        heapq.heappush(pq, (0,0,0))
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]

        dists = [[float('inf')] * len(heights[0]) for _ in range(len(heights))]

        dists[0][0] = 0
        newEffort = float('-inf')
        while pq:
            currWeight, ci, cj = heapq.heappop(pq)
            if currWeight > dists[ci][cj]:
                continue
            for di,dj in dirs:
                ni,nj = ci + di, cj + dj
                if 0 <= ni < len(heights) and 0 <= nj < len(heights[0]):
                    newEffort = max(currWeight, abs(heights[ni][nj] - heights[ci][cj]))
                    if dists[ni][nj] > newEffort:
                        dists[ni][nj] = newEffort
                        heapq.heappush(pq,(dists[ni][nj],ni,nj))
        return dists[len(heights)-1][len(heights[0])-1]