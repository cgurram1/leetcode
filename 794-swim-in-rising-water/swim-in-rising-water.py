"""


10,12,4,6
9,11,3,5
1,7,13,8
2,0,15,14


"""
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        dists = [[float('inf')] * len(grid[0]) for _ in range(len(grid))]
        dists[0][0] = grid[0][0]
        queue = [(grid[0][0],0,0)]
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        while queue:
            poppedDist,ci,cj = heapq.heappop(queue)
            for di,dj in dirs:
                ni,nj = ci + di, cj + dj
                if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
                    nextDist = max(poppedDist, grid[ni][nj])
                    if nextDist < dists[ni][nj]:
                        dists[ni][nj] = nextDist
                        heapq.heappush(queue, (dists[ni][nj],ni,nj))
        return dists[len(grid)-1][len(grid[0])-1]