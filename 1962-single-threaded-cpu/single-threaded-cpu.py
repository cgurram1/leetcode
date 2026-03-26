class Solution:
    def getOrder(self, tasks):
        for i, task in enumerate(tasks):
            task.append(i)
        tasks.sort(key=lambda x: x[0])
        available = []
        time = 0
        left = 0
        result = []
        while left < len(tasks) or available:
            if not available and time < tasks[left][0]:
                time = tasks[left][0]
            while left < len(tasks) and tasks[left][0] <= time:
                heapq.heappush(available, (tasks[left][1], tasks[left][2]))
                left += 1
            processing_time, idx = heapq.heappop(available)
            result.append(idx)
            time += processing_time
        return result