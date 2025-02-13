class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        res_min = float('inf')
        row = len(heights)
        col = len(heights[0])
        if row == 1 and col == 1:
            return 0
        distance = [[float('inf') for _ in range(col)] for _ in range(row)]
        x = [1,0,-1,0]
        y = [0,-1,0,1]

        pq = [(0,(0,0))]
        distance[0][0] = 0
        while(pq):
            diff,(i,j) = heapq.heappop(pq)
            for k in range(4):
                nexti = i + x[k]
                nextj = j + y[k]
                if nexti >= 0 and nexti < row and nextj >= 0 and nextj < col:
                    effort = abs(heights[i][j] - heights[nexti][nextj])
                    new_effort = max(diff,effort)
                    if new_effort < distance[nexti][nextj]:
                        distance[nexti][nextj] = new_effort
                        heapq.heappush(pq,(new_effort,(nexti,nextj)))
        print(distance)
        return distance[row-1][col-1]
