class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        adjList = [[] for _ in range(len(isConnected))]
        for r in range(len(isConnected)):
            for c in range(len(isConnected)):
                if r != c and isConnected[r][c] == 1:
                    adjList[r].append(c)
        def BFS(node):
            queue = [node]
            while queue:
                currNode = queue.pop()
                for adjNode in adjList[currNode]:
                    if visited[adjNode] == 0:
                        visited[adjNode] = 1
                        queue.append(adjNode)
        def DFS(node):
            visited[node] = 1
            for adjNode in adjList[node]:
                if visited[adjNode] == 0:
                    DFS(adjNode)
        res = 0
        visited = [0 for _ in range(len(isConnected))]
        for node in range(len(isConnected)):
            if visited[node] == 0:
                res+=1
                # BFS(node)
                DFS(node)
        return res
