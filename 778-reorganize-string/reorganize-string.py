from collections import Counter
class Solution:
    def reorganizeString(self, s: str) -> str:
        count = list(Counter(s).items())
        arr = []
        for c in count:
            arr.append((-c[1],c[0]))
        heapq.heapify(arr)
        toPush = heapq.heappop(arr)
        res = "" + toPush[1]
        toPush = (toPush[0]+1,toPush[1])
        Next = None
        while(arr):
            Next = heapq.heappop(arr)
            res+=Next[1]
            Next = (Next[0]+1,Next[1])
            if toPush[0]!= 0:
                heapq.heappush(arr,toPush)
            toPush = Next
        if Next and Next[0] == 0:
            return res
        elif not Next and toPush[0] == 0:
            return res
        return ""

