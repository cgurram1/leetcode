class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heapArr = []
        for i in stones:
            heapq.heappush(heapArr,-1 * i)
        while(len(heapArr) > 1):
            first = -heapq.heappop(heapArr)
            second = -heapq.heappop(heapArr)
            if first - second != 0:
                heapq.heappush(heapArr,-(first - second))
        if heapArr:
            return -heapArr[0]
        else:
            return 0
