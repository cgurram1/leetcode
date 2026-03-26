class Solution:
    def leastInterval(self, tasks, n):
        counter = Counter(tasks)
        maxHeap = []
        waitQueue = deque()
        for key in counter:
            heapq.heappush(maxHeap, (-counter[key], key))
        time = 0
        while maxHeap or waitQueue:
            if waitQueue and time - waitQueue[0][1] >= n + 1:
                task, _ = waitQueue.popleft()
                heapq.heappush(maxHeap, (-counter[task], task))
            if maxHeap:
                _, task = heapq.heappop(maxHeap)
                counter[task] -= 1
                if counter[task] > 0:
                    waitQueue.append((task, time))
            else:
                time = waitQueue[0][1] + n + 1
                continue
            time += 1
        return time
                
            