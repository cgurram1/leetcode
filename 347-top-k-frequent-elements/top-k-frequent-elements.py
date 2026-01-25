class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = {}
        for i in nums:
            if i in d:
                d[i]+=1
            else:
                d[i] = 1
        heap = []
        for item in d.items():
            heapq.heappush(heap, [item[1], item[0]])
            if(len(heap) > k):
                heapq.heappop(heap)
        return [item[1] for item in heap]
