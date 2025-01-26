class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        stack.append((0,temperatures[0]))
        res = [0] * len(temperatures)
        for i in range(len(temperatures)):
            while(stack and temperatures[i] > stack[-1][1]):
                res[stack[-1][0]] = i - stack[-1][0]
                stack.pop(-1)
            stack.append((i,temperatures[i]))
        return res
