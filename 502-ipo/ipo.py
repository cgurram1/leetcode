class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        proCaps = [(-p,c) for p,c in zip(profits,capital)]
        proCaps.sort(key=lambda x:x[1])
        profitHeap = []
        capitlHeap = []
        i = 0
        while k>0:
            while i < len(proCaps) and proCaps[i][1] <= w:
                heapq.heappush(profitHeap,proCaps[i])
                i+=1
            if profitHeap:
                popped = heapq.heappop(profitHeap)
                w = w + popped[0]*-1
                k-=1
            else:
                return w
        return w
                
