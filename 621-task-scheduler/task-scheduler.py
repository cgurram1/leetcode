class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hp = []
        waiting = deque()
        currTime = 0
        freqs = defaultdict(int)
        for task in tasks:
            freqs[task]+=1
        for k,v in freqs.items():
            heapq.heappush(hp,(-v,k,0))
        while hp or waiting:
            while waiting and waiting[0][2] <= currTime:
                heapq.heappush(hp,waiting.popleft())
            if hp:
                popped = heapq.heappop(hp)
                if popped[0] < -1:
                    waiting.append((popped[0]+1,popped[1],currTime+n+1))
                currTime+=1
            else:
                currTime = waiting[0][2]
        return currTime

