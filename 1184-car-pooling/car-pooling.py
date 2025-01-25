class Solution:
    def carPooling(self, trips: List[List[int]], cap: int) -> bool:
        pickup = [(x[1], x[2], x[0]) for x in trips]
        heapq.heapify(pickup)
        dropoff = []
        while pickup:
            while dropoff and dropoff[0][0] <= pickup[0][0]:
                _, passengers = heapq.heappop(dropoff)
                cap += passengers
            start, end, passengers = heapq.heappop(pickup)
            if passengers <= cap:
                cap -= passengers
                heapq.heappush(dropoff, (end, passengers))
            else:
                return False
        while dropoff:
            _, passengers = heapq.heappop(dropoff)
            cap += passengers
            
        return True


            
