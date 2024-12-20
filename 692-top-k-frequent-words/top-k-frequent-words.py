class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        myDict = {}
        for word in words:
            if word in myDict:
                myDict[word]+=1
            else:
                myDict[word] = 1
        max_heap = []
        for key in myDict:
            heapq.heappush(max_heap,(-myDict[key],key))
        count = 0
        res = []
        while(count < k):
            res.append(heapq.heappop(max_heap)[1])
            count+=1
        return res

        