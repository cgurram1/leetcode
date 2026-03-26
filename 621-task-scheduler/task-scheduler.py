class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        maxHeap = []
        counter = Counter(tasks)
        waitQueue = deque()
        for key in counter:
            heapq.heappush(maxHeap,(-counter[key],key))
        time = 0
        while waitQueue or maxHeap:
            if waitQueue and time - waitQueue[0][1] > n:
                poppedTask,_ = waitQueue.popleft()
                heapq.heappush(maxHeap, (-counter[poppedTask],poppedTask))
            if maxHeap:
                _, task = heapq.heappop(maxHeap)
                counter[task]-=1
                if counter[task] == 0:
                    counter.pop(task)
                else:
                    waitQueue.append((task,time))
            time+=1
        return time
                
            