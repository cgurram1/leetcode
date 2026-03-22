class Solution:
    def longestValidParentheses(self, s: str) -> int:
        intervals = []
        stack = []
        for i,c in enumerate(s):
            if c == "(":
                stack.append((c,i))
            elif stack and stack[-1][0] == "(":
                intervals.append((stack.pop()[1],i))
        result = 0
        count = 0
        prevInterval = None
        # print(intervals)
        while intervals:
            currInterval = intervals.pop()
            if prevInterval == None:
                count = currInterval[1] - currInterval[0] + 1
                prevInterval = currInterval
            else:
                if prevInterval[0] < currInterval[0] < prevInterval[1] and prevInterval[0] < currInterval[1] < prevInterval[1]:
                    continue
                elif currInterval[1] + 1 == prevInterval[0]:
                    prevInterval = (currInterval[0],prevInterval[1])
                    count += (currInterval[1] - currInterval[0] + 1)
                else:
                    prevInterval = currInterval
                    result = max(result,count)
                    count = currInterval[1] - currInterval[0] + 1
        # print(count)
        return max(result,count)