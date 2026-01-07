class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        sorted_times = sorted(times, key=lambda x:x[0])
        # print(sorted_times)
        i = 0
        time = 0
        seat = 0
        filledChairs = []
        emptyChairs = []
        while(times[targetFriend] != sorted_times[i]):
            # print(i)
            # at time t remove all the chairs from the filledChairs that leaves at time
            while(filledChairs and filledChairs[0][0] <= sorted_times[i][0]):
                heapq.heappush(emptyChairs,heapq.heappop(filledChairs)[1])
            if(emptyChairs):
                heapq.heappush(filledChairs, (sorted_times[i][1], heapq.heappop(emptyChairs)))
            else:
                heapq.heappush(filledChairs, (sorted_times[i][1],seat))
                seat+=1
            i+=1
            # print(filledChairs)
            # print(emptyChairs)
        while(filledChairs and filledChairs[0][0] <= sorted_times[i][0]):
            heapq.heappush(emptyChairs,heapq.heappop(filledChairs)[1])
        if(emptyChairs):
            return emptyChairs[0]
        else:
            return seat