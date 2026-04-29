class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        adjList = [[] for _ in range(n)]
        for connection in connections:
            adjList[connection[0]].append(connection[1])
            adjList[connection[1]].append(connection[0])
        minTimes = [float('inf') for _ in range(n)]
        disc = [-1 for _ in range(n)]
        critical = []
        def fun(node, counter, parent):
            disc[node] = counter
            minTimes[node] = counter
            for adjNode in adjList[node]:
                if adjNode != parent:
                    if disc[adjNode] == -1:
                        fun(adjNode, counter + 1, node)
                        minTimes[node] = min(minTimes[node], minTimes[adjNode])
                        if minTimes[adjNode] > disc[node]:
                            critical.append([node, adjNode])
                    else:
                        minTimes[node] = min(minTimes[node], disc[adjNode])
        fun(0,0,-1)
        return critical
