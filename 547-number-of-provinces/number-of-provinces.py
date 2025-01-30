class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        visited = [[0 for _ in range(len(isConnected))] for _ in range(len(isConnected))]
        count = 0
        def dfs(i,j):
            visited[i][j] = 1
            visited[j][i] = 1
            for k in range(len(isConnected)):
                if isConnected[j][k] == 1 and visited[j][k] == 0:
                    dfs(j,k)
        for i in range(len(isConnected)):
            for j in range(len(isConnected)):
                if isConnected[i][j] == 1 and visited[i][j] == 0:
                    count+=1
                    dfs(i,j)
        return count