

class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        for node1,node2 in adjacentPairs:
            graph[node1].append(node2)
            graph[node2].append(node1)
        visited = set()
        root = -1
        for key,value in graph.items():
            if(len(value) == 1):
                root = key
                break
        result = []
        def dfs(node):
            result.append(node)
            visited.add(node)
            for adj in graph[node]:
                if(adj not in visited):
                    dfs(adj)
        dfs(root)
        return result