"""

[2,2,3,1,8,7,4,5]
8,7,5,4,3,2,2,1

"""
class Solution:
    def minProcessingTime(self, processorTime: List[int], tasks: List[int]) -> int:
        totalTime = 0
        processor = 0
        tasks.sort(reverse=True)
        processorTime.sort()
        for i in range(0,len(tasks),4):
            maxV = 0
            # print("Processor", processor)
            for j in range(i,i+4):
                # print(tasks[j])
                maxV = max(maxV,tasks[j])
            totalTime = max(totalTime, (maxV + processorTime[processor]))
            processor+=1
        return totalTime