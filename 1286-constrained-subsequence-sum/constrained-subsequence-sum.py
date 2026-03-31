class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        maxHeap = []
        left = 0
        maxResult = float('-inf')
        temp = [n for n in nums]

        while left < len(temp):
            while maxHeap and left - maxHeap[0][1] > k:
                heapq.heappop(maxHeap)
            if maxHeap:
                temp[left] = max(temp[left],temp[left]-maxHeap[0][0])
            heapq.heappush(maxHeap,(-temp[left],left))
            left+=1
        return max(temp)
        
