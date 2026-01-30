"""

l = []
count = 7
popped = 8

"""

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        l = [1]
        count = 0
        popped = -1
        while(True):
            popped = heapq.heappop(l)
            count+=1
            if(count == n):
                return popped
            for i in [2,3,5]:
                if popped * i not in l:
                    heapq.heappush(l, popped*i)
        return 0
        



