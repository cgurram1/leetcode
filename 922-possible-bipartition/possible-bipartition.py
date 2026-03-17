class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        adjList = [[] for _ in range(n+1)]
        for dislike in dislikes:
            adjList[dislike[0]].append(dislike[1])
            adjList[dislike[1]].append(dislike[0])
        queue = deque()
        visited = [-1 for _ in range(n+1)]
        def BFS(node):
            queue.append(node)
            visited[node] = 0
            while queue:
                currNode = queue.popleft()
                for adjNode in adjList[currNode]:
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
        for node in range(1,n+1):
            if visited[node] == -1:
                if BFS(node) == False:
                    return False
        return True