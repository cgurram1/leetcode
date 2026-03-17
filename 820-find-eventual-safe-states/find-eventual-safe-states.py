class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        reversedGraph = [[] for _ in range(len(graph))]
        inDegrees = [0 for _ in range(len(graph))]
        result = []
        for node in range(len(graph)):
            for nextNode in graph[node]:
                reversedGraph[nextNode].append(node)
                inDegrees[node]+=1
        # print(graph)
        # print(reversedGraph)
        # print(inDegrees)
        queue = deque()
        for i,degree in enumerate(inDegrees):
            if degree == 0:
                queue.append(i)
        # print(queue)
        while queue:
            currNode = queue.popleft()
            result.append(currNode)
            for adjNode in reversedGraph[currNode]:
                inDegrees[adjNode]-=1
                if inDegrees[adjNode] == 0:
                    queue.append(adjNode)
        return sorted(result)

