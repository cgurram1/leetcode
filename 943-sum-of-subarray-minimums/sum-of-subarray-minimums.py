class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        prev_mins = [0 for _ in range(len(arr))]
        next_mins = [0 for _ in range(len(arr))]
        stack = []
        for i in range(len(arr)):
            while(stack and arr[i] <= arr[stack[-1]]):
                stack.pop(-1)
            if stack:
                prev_mins[i] = stack[-1]
            else:
                prev_mins[i] = -1
            stack.append(i)
        stack = []
        for i in range(len(arr)-1,-1,-1):
            while(stack and arr[i] < arr[stack[-1]]):
                stack.pop(-1)
            if stack:
                next_mins[i] = stack[-1]
            else:
                next_mins[i] = len(arr)
            stack.append(i)
        print(next_mins)
        print(prev_mins)
        res = 0
        for i in range(len(arr)):
            res = (res + arr[i] * ((i - prev_mins[i]) * (next_mins[i] - i))) % (10**9 + 7)
        return res