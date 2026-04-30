class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        adjList = [[] for _ in range(n)]
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
        def fun(node,parent):
            curr = 0
            for adjNode in adjList[node]:
                if adjNode != parent:
                    val = fun(adjNode,node)
                    if val >= 0:
                        curr += (val + 2)
            if curr == 0:
                if hasApple[node]:
                    return 0
                return -1 
            return curr
        return max(0,fun(0,-1))