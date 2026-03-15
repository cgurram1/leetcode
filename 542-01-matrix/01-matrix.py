class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        n = len(mat)
        m = len(mat[0])
        result = [[float('inf')]* m for _ in range(n)]
        for r in range(n):
            for c in range(m):
                if mat[r][c] == 0:
                    result[r][c] = 0
                    queue.append((r,c))
        
        while queue:
            cr,cc = queue.popleft()
            for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                nr, nc = cr + di, cc + dj
                if nr >= 0 and nr < n and nc >= 0 and nc < m:
                    if result[nr][nc] == float('inf'):
                        result[nr][nc] = result[cr][cc] + 1
                        queue.append((nr,nc))
        return result



        