class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        adjList = defaultdict(list)
        for edge in edges:
            adjList[edge[1]].append(edge[0])
        result = []
        
        @lru_cache(None)
        def dfs(currNode):
            ancestors = set()
            for adjNode in adjList[currNode]:
                ancestors.add(adjNode)
                for x in dfs(adjNode):
                    ancestors.add(x)
            return ancestors
        
        
        for i in range(n):
            result.append(sorted(dfs(i)))
        return result

