from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        string = "".join(tasks)
        print(string)
        freqArr = Counter(string)
        arr = []
        for i in freqArr:
            arr.append((-freqArr[i],i))
        heapq.heapify(arr)
        index = 0
        newStr = ""
        q = []
        while(True):
            if len(q) == 0 and len(arr) == 0:
                return len(newStr)
            if index <= n:
                if len(arr) > 0:
                    popped = heapq.heappop(arr)
                    newStr+=popped[1]
                    index+=1
                    currCount = -popped[0] - 1
                    if currCount > 0:
                        q.append((-currCount,popped[1]))
                else:
                    newStr+="0"
                    index+=1
            else:
                arr.extend(q)
                q = []
                heapq.heapify(arr)
                index = 0
        return 0
            
        