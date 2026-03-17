class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        reversedGraph = [[] for _ in range(n)]
        inDegrees = [0] * n
        is_safe = [False] * n

        for node, neighbors in enumerate(graph):
            for neighbor in neighbors:
                reversedGraph[neighbor].append(node)
            inDegrees[node] = len(neighbors)

        queue = deque([i for i, d in enumerate(inDegrees) if d == 0])

        while queue:
            curr = queue.popleft()
            is_safe[curr] = True
            for prev in reversedGraph[curr]:
                inDegrees[prev] -= 1
                if inDegrees[prev] == 0:
                    queue.append(prev)
        return [i for i, safe in enumerate(is_safe) if safe]