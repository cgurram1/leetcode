class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        smallGrids = [[set() for _ in range(3)] for _ in range(3)]
        row = []
        col = []
        for i in range(9):
            smallGrids.append(set())
            row.append(set())
            col.append(set())
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    if board[i][j] in smallGrids[i//3][j//3] or board[i][j] in row[i] or board[i][j] in col[j]:
                        return False
                    smallGrids[i//3][j//3].add(board[i][j])
                    row[i].add(board[i][j])
                    col[j].add(board[i][j])
        return True