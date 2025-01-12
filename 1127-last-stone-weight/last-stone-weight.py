class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones = [-1 * num for num in stones]
        heapq.heapify(stones)
        while(True):
            if len(stones) == 1:
                return -stones[0]
            elif len(stones) == 0:
                return 0
            x,y = -heapq.heappop(stones),-heapq.heappop(stones)
            if x != y:
                diff = x - y
                if diff > 0:
                    diff*=-1
                heapq.heappush(stones,diff)