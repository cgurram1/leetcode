class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        temp = []
        res = 0
        # for i in range(len(cost)):
        #     res+=(gas[i] - cost[i])
        #     temp.append(gas[i] - cost[i])
        # print(temp)
        if sum(gas) - sum(cost) < 0:
            return -1
        curr_sum = 0
        res = 0
        for i in range(len(gas)):
            curr_sum += (gas[i] - cost[i])
            if curr_sum < 0:
                curr_sum = 0
                res = i + 1
        return res

                    
                

                    
        