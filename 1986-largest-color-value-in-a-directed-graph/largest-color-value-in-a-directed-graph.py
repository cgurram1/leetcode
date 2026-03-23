class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        adjList = [[] for _ in range(n)]
        for edge in edges:
            adjList[edge[0]].append(edge[1])
        dp = {}

        def DFS(node,visited, path):
            if len(adjList[node]) == 0:
                data = [0 for _ in range(26)]
                data[ord(colors[node]) - ord('a')]+=1
                dp[node] = data
                return data
            data = [0 for _ in range(26)]
            for adjNode in adjList[node]:
                if visited[adjNode] == -1:
                    visited[adjNode] = 1
                    path.add(adjNode)
                    returnedData = DFS(adjNode,visited,path)
                    if returnedData == -1:
                        return -1
                    path.remove(adjNode)
                else:
                    if adjNode in path:
                        return -1
                    else:
                        returnedData = dp[adjNode]
                data = [max(di,ri) for di,ri in zip(data,returnedData)]
            data[ord(colors[node]) - ord('a')]+=1
            dp[node] = data
            return data
        visited = [-1 for _ in range(n)]
        path = set()
        result = 0
        for i in range(n):
            if visited[i] == -1:
                visited[i] = 1
                path.add(i)
                returnedData = DFS(i,visited,path)
                if returnedData == -1:
                    return -1
                result = max(result, max(returnedData))
                path.remove(i)
        return result
