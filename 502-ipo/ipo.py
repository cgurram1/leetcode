class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        proCaps = list(zip(capital, profits))
        proCaps.sort()

        profitHeap = []
        i = 0

        while k > 0:
            while i < len(proCaps) and proCaps[i][0] <= w:
                heapq.heappush(profitHeap, -proCaps[i][1])
                i += 1

            if not profitHeap:
                return w

            w += -heapq.heappop(profitHeap)
            k -= 1

        return w
                
