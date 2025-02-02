class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0 for _ in range(numCourses)]
        queue = []
        adj = [[] for _ in range(numCourses)]
        for arr in prerequisites:
            adj[arr[0]].append(arr[1])
        for arr in adj:
            for i in arr:
                inDegree[i]+=1
        for i in range(numCourses):
            if inDegree[i] == 0:
                queue.append(i)
        while(queue):
            curr = queue.pop(0)
            numCourses-=1
            for nextNode in adj[curr]:
                inDegree[nextNode]-=1
                if inDegree[nextNode] == 0:
                    queue.append(nextNode)
        if numCourses == 0:
            return True
        return False

