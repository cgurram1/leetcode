class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        myDict = {}
        distances = set()
        for point in points:
            x = point[0]
            y = point[1]
            dist = math.sqrt((x ** 2 ) + (y ** 2))
            distances.add(dist)
            if not dist in myDict:
                myDict[dist] = [point]
            else:
                myDict[dist].append(point)
        listDistances = list(distances)
        heapq.heapify(listDistances)
        count = 0
        myArr = []
        tempK = k
        while(tempK > 0 and len(listDistances) > 0):
            popped = heapq.heappop(listDistances)
            curr = len(myDict[popped])
            if count + curr <= k:
                count += curr
                myArr.extend(myDict[popped])
            else:
                remaining = k - count
                myArr.extend(myDict[popped][:remaining])
            tempK = tempK - 1
        return myArr
