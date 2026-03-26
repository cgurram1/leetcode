class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key=lambda x:x[1])
        dropOff = []
        for trip in trips:
            #Dropoff all before picking this
            currPickUp = trip[1]
            while dropOff and dropOff[0][0] <= currPickUp:
                capacity+=heapq.heappop(dropOff)[1]
            if capacity >= trip[0]:
                capacity-=trip[0]
                heapq.heappush(dropOff,(trip[2],trip[0]))
            else:
                return False
        return True
