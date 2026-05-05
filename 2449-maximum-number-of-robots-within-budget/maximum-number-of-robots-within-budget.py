class Solution:
    def maximumRobots(self, chargeTimes: List[int], runningCosts: List[int], budget: int) -> int:
        n = len(chargeTimes)
        pq = []
        prefixSum = [0 for _ in range(n)]
        prefixSum[0] = runningCosts[0]
        for i in range(1,n):
            prefixSum[i] = prefixSum[i-1] + runningCosts[i]
        left = 0
        maxLength = 0
        currBudget = 0
        for right in range(n):
            heapq.heappush(pq,(-chargeTimes[right],right))
            while pq and pq[0][1] < left:
                heapq.heappop(pq)
            maxVal = -pq[0][0]
            sRunning = 0
            if left > 0:
                sRunning = prefixSum[right] - prefixSum[left-1]
            else:
                sRunning = prefixSum[right]
            currBudget = maxVal + (right-left + 1) * sRunning
            
            if currBudget > budget:
                left+=1
                if pq[0][1] < left:
                    heapq.heappop(pq)
            if left > 0:
                sRunning = prefixSum[right] - prefixSum[left-1]
            else:
                sRunning = prefixSum[right]
            currBudget = maxVal + (right-left + 1) * sRunning
            if currBudget <= budget:
                maxLength = max(maxLength, right - left + 1)
        return maxLength
                


