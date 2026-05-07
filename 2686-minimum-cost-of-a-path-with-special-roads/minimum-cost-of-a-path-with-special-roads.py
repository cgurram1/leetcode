class Solution:
    def minimumCost(self, start: List[int], target: List[int], specialRoads: List[List[int]]) -> int:
        pq = []
        dists = {}
        pq.append((0,start[0],start[1]))
        dists[(start[0],start[1])] = 0
        while pq:
            currWeight, ci, cj = heapq.heappop(pq)
            if currWeight > dists[(ci,cj)]:
                continue
            for x1i, y1i, x2i, y2i, costi in specialRoads:
                if (x2i, y2i) not in dists or dists[(x2i, y2i)] > currWeight + abs(x1i - ci) + abs(y1i - cj) + costi:
                    dists[(x2i, y2i)] = currWeight + abs(x1i - ci) + abs(y1i - cj) + costi
                    heapq.heappush(pq,(dists[(x2i, y2i)], x2i, y2i))
            if (target[0],target[1]) not in dists or dists[(target[0],target[1])] > currWeight + abs(target[0] - ci) + abs(target[1] - cj):
                dists[(target[0],target[1])] = currWeight + abs(target[0] - ci) + abs(target[1] - cj)
        return dists[(target[0],target[1])]
        