class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        queue = deque()
        visited = [-1 for _ in range(len(graph))]
        def BFS(node):
            queue.append(node)
            visited[node] = 0
            while queue:
                currNode = queue.popleft()
                for adjNode in graph[currNode]:
                    if visited[currNode] == 0:
                        if visited[adjNode] == -1:
                            visited[adjNode] = 1
                            queue.append(adjNode)
                        elif visited[adjNode] == 0:
                            return False
                    else:
                        if visited[adjNode] == -1:
                            visited[adjNode] = 0
                            queue.append(adjNode)
                        elif visited[adjNode] == 1:
                            return False
            return True
        for node in range(len(graph)):
            if visited[node] == -1:
                if BFS(node) == False:
                    return False
        return True

