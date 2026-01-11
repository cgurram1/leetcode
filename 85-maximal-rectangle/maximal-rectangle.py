class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        def fun(heights):
            prevSmall = []
            nextSmall = []
            stack = []

            # previous smaller
            for i in range(len(heights)):
                while stack and heights[stack[-1]] >= heights[i]:
                    stack.pop()
                prevSmall.append(stack[-1] if stack else -1)
                stack.append(i)

            stack = []

            # next smaller
            for i in range(len(heights)-1, -1, -1):
                while stack and heights[stack[-1]] >= heights[i]:
                    stack.pop()
                nextSmall.append(stack[-1] if stack else len(heights))
                stack.append(i)

            nextSmall.reverse()

            maxV = 0
            for i in range(len(heights)):
                maxV = max(maxV, heights[i] * (nextSmall[i] - prevSmall[i] - 1))
            return maxV

        rows, cols = len(matrix), len(matrix[0])
        heightsArr = [[0]*cols for _ in range(rows)]

        for j in range(cols):
            heightsArr[0][j] = int(matrix[0][j])

        for i in range(1, rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    heightsArr[i][j] = heightsArr[i-1][j] + 1
                else:
                    heightsArr[i][j] = 0

        maxV = 0
        for arr in heightsArr:
            maxV = max(maxV, fun(arr))

        return maxV