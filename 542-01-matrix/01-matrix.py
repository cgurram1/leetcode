class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        result = [[float('inf')]* len(mat[0]) for _ in range(len(mat))]
        for r in range(len(mat)):
            for c in range(len(mat[0])):
                if mat[r][c] == 0:
                    result[r][c] = 0
                    queue.append((r,c,0))
        while queue:
            cr,cc,level = queue.popleft()
            for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                nr, nc = cr + di, cc + dj
                if nr >= 0 and nr < len(mat) and nc >= 0 and nc < len(mat[0]):
                    if result[nr][nc] == float('inf'):
                        result[nr][nc] = level + 1
                        queue.append((nr,nc, level + 1))
        return result



        