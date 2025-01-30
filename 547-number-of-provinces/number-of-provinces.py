class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        visited = [0 for _ in range(len(isConnected))]
        count = 0
        def dfs(i):
            visited[i] = 1
            for k in range(len(isConnected)):
                if isConnected[i][k] == 1 and visited[k] == 0:
                    dfs(k)
        for i in range(len(isConnected)):
            if visited[i] == 0:
                count+=1
                dfs(i)
        return count