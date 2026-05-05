class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        # dp = {}
        # def fun(fuel, index):
        #     currPos = 0 if index == -1 else stations[index][0]
        #     if fuel + currPos >= target:
        #         return 0
        #     if (fuel,index) in dp:
        #         return dp[(fuel,index)]
        #     ans = float('inf')
        #     for i in range(index + 1, len(stations)):
        #         if fuel + currPos >= stations[i][0]:
        #             ans = min(ans,fun(fuel - (stations[i][0] - currPos) + stations[i][1], i))
        #     dp[(fuel,index)] = 1 + ans
        #     return 1 + ans
        # res = fun(startFuel,-1)
        # if res == float('inf'):
        #     return -1
        # return res
        
        stations.sort()
        crossed = []
        fuel = startFuel
        index = 0
        count = 0
        
        while True:
            if fuel >= target:
                return count
            while index < len(stations) and stations[index][0] <= fuel:
                heapq.heappush(crossed, -stations[index][1])
                index += 1
            if not crossed:
                return -1
            fuel += -heapq.heappop(crossed)
            count += 1
        