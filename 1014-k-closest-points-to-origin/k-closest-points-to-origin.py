class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        res = []
        for point in points:
            heapq.heappush(res,(-1*math.sqrt(point[0]**2 + point[1]**2),point))
            if len(res) > k:
                heapq.heappop(res)
        ans = []
        while res:
            ans.append(heapq.heappop(res)[1])
        return ans