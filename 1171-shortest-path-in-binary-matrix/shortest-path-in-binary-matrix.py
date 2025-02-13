class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] != 0:
            return -1
        visited = [[float('inf') for _ in range(len(grid))] for _ in range(len(grid))]
        x = [1,1,1,-1,-1,-1,0,0]
        y = [1,0,-1,1,0,-1,1,-1]
        pq = [(0,(0,0))]
        dist = 0
        while(pq):
            dist,(i,j) = heapq.heappop(pq)
            visited[i][j] = dist
            for k in range(8):
                nexti = i + x[k]
                nextj = j + y[k]
                if nexti >= 0 and nexti < len(grid) and nextj >= 0 and nextj < len(grid) and grid[nexti][nextj] == 0:
                    if visited[nexti][nextj] > dist + 1:
                        visited[nexti][nextj] = dist + 1
                        heapq.heappush(pq,(dist + 1, (nexti,nextj)))
        if visited[-1][-1] == float('inf'):
            return -1
        return visited[-1][-1] + 1