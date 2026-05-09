"""

"#","#","*",".","*","."
"#","#","#","*",".","."
"#","#","#",".","#","."


"""

class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        for row in range(len(boxGrid)):
            gaps = deque()
            left = len(boxGrid[0]) - 1
            while left >= 0:
                if boxGrid[row][left] == '.':
                    gaps.append(left)
                elif boxGrid[row][left] == '*':
                    gaps.clear()
                else:
                    if gaps:
                        boxGrid[row][left] = '.'
                        boxGrid[row][gaps.popleft()] = '#'
                        gaps.append(left)
                left-=1
        # print(boxGrid)
        result = [[0 for _ in range(len(boxGrid))] for _ in range(len(boxGrid[0]))]
        for i in range(len(boxGrid)):
            for j in range(len(boxGrid[0])):
                result[j][i] = boxGrid[len(boxGrid)- i - 1][j]
        return result


"""

"#",".","*","."
"#","#","*","."

# .


"""
