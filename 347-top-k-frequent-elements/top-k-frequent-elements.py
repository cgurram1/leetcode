class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        myDict = {}
        myHeap = []
        for i in nums:
            if i in myDict:
                myDict[i] = myDict[i] + 1
            else:
                myDict[i] = 1
        for key in myDict:
            heapq.heappush(myHeap,(-myDict[key],key))
        res = []
        count = 0
        while(count < k):
            res.append(heapq.heappop(myHeap)[1])
            count+=1
        return res