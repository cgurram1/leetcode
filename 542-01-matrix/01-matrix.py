class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = []
        result = [[float('inf')]* len(mat[0]) for _ in range(len(mat))]
        for r in range(len(mat)):
            for c in range(len(mat[0])):
                if mat[r][c] == 0:
                    result[r][c] = 0
                    queue.append((r,c,0))
        queue.append(None)
        level = 0
        while queue[0] != None:
            while queue[0] != None:
                cr,cc,level = queue.pop(0)
                for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                    nr, nc = cr + di, cc + dj
                    if nr >= 0 and nr < len(mat) and nc >= 0 and nc < len(mat[0]):
                        if result[nr][nc] == float('inf'):
                            result[nr][nc] = level + 1
                            queue.append((nr,nc, level + 1))
            queue.append(queue.pop(0))
        return result



        