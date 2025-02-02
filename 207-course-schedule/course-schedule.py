class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0 for _ in range(numCourses)]
        queue = []
        for arr in prerequisites:
            inDegree[arr[1]]+=1
        for i in range(numCourses):
            if inDegree[i] == 0:
                queue.append(i)
        while(queue):
            curr = queue.pop(0)
            numCourses-=1
            for arr in prerequisites:
                if arr[0] == curr:
                    if inDegree[arr[1]] > 0:
                        inDegree[arr[1]]-=1
                    if inDegree[arr[1]] == 0:
                        queue.append(arr[1])
        if numCourses == 0:
            return True
        return False

