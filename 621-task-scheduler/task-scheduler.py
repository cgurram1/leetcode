from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        string = "".join(tasks)
        freqArr = Counter(string)
        arr = []
        for i in freqArr:
            arr.append(-freqArr[i])
        heapq.heapify(arr)
        index = 0
        q = []
        res = 0
        while(True):
            if len(q) == 0 and len(arr) == 0:
                return res
            if index <= n:
                if len(arr) > 0:
                    popped = heapq.heappop(arr)
                    res+=1
                    index+=1
                    currCount = -popped - 1
                    if currCount > 0:
                        q.append(-currCount)
                else:
                    res+=1
                    index+=1
            else:
                arr.extend(q)
                q = []
                heapq.heapify(arr)
                index = 0
        return 0
            
        