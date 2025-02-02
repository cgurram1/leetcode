class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        queue = []
        res = []
        inDegree = [0 for _ in range(numCourses)]
        adj = [[] for _ in range(numCourses)]
        for arr in prerequisites:
            adj[arr[1]].append(arr[0])
        for arr in adj:
            for i in arr:
                inDegree[i]+=1
        for i in range(numCourses):
            if inDegree[i] == 0:
                queue.append(i)
        while(queue):
            curr = queue.pop(0)
            res.append(curr)
            for nextNode in adj[curr]:
                inDegree[nextNode]-=1
                if inDegree[nextNode] == 0:
                    queue.append(nextNode)
        if len(res) != numCourses:
            return []
        return res