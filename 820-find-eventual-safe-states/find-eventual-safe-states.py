class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        isSafe = [-1 for _ in range(len(graph))]
        def dfs(Node):
            if isSafe[Node] != -1:
                if isSafe[Node] == 1:
                    return True
                else:
                    return False
            isSafe[Node] = 0
            for nextNode in graph[Node]:
                if dfs(nextNode) == False:
                    return False
            isSafe[Node] = 1
            return True
        res = []
        for i in range(len(graph)):
            if dfs(i) == True:
                res.append(i)
        return res
            

