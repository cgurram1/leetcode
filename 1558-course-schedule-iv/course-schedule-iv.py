class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        adjList = [[]for _ in range(numCourses)]
        def REC(node):
            arr = set()
            for adjNode in adjList[node]:
                arr.add(adjNode)
                if adjNode not in allPre:
                    allPre[adjNode] = REC(adjNode)
                arr.update(allPre[adjNode])
            return arr
        for course in prerequisites:
            adjList[course[1]].append(course[0])
        # print(adjList)
        allPre = {}
        for i in range(numCourses):
            if i not in allPre:
                allPre[i] = REC(i)
        # print(allPre)
        result = []
        for query in queries:
            if query[0] in allPre[query[1]]:
                result.append(True)
            else:
                result.append(False)
        return result
        


        