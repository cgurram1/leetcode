class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        visited = [[0 for _ in range(len(mat[0]))] for _ in range(len(mat))]
        res = [[0 for _ in range(len(mat[0]))] for _ in range(len(mat))]
        queue = []
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    queue.append((i,j,0))
                    visited[i][j] = 1
                    res[i][j] = 0
        x = [1,-1,0,0]
        y = [0,0,1,-1]
        while(queue):
            i,j,val = queue.pop(0)
            for k in range(4):
                nexti = i + x[k]
                nextj = j + y[k]
                if nexti >= 0 and nexti < len(mat) and nextj >= 0 and nextj < len(mat[0]) and visited[nexti][nextj] == 0:
                    visited[nexti][nextj] = 1
                    queue.append((nexti,nextj,val + 1))
                    res[nexti][nextj] = val + 1
        return res
            