class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pq = []
        for ch in nums:
            heapq.heappush(pq,ch)
            if len(pq) > k:
                heapq.heappop(pq)
        return pq[0]
        