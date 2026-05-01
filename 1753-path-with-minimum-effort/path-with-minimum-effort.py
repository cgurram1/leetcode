class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        dists = [[float('inf') for _ in range(len(heights[0]))] for _ in range(len(heights))]
        # print(dists)
        queue = []
        heapq.heappush(queue, (0,0,0))
        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        n,m = len(heights),len(heights[0])
        while queue:
            weight,r,c = heapq.heappop(queue)
            if (r,c) == (n-1,m-1):
                return weight
            for di,dj in dirs:
                ni,nj = r + di, c + dj
                if 0 <= ni < n and 0 <= nj < m:
                    nextWeight = max(weight, abs(heights[r][c] - heights[ni][nj]))
                    if dists[ni][nj] > nextWeight:
                        dists[ni][nj] = nextWeight
                        heapq.heappush(queue,(nextWeight,ni,nj))
        return -1

            