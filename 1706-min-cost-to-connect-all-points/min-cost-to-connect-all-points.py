class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        queue = [(0,(points[0][0],points[0][1]))]
        visited = set()
        total = 0
        while len(visited) < len(points):
            dist,point = heapq.heappop(queue)
            if point not in visited:
                total+=dist
                visited.add((point[0],point[1]))
                for pi,pj in points:
                    if (pi,pj) not in visited:
                        nextDist = abs(pi-point[0]) + abs(pj-point[1])
                        heapq.heappush(queue, (nextDist, (pi,pj)))
        return total
            
