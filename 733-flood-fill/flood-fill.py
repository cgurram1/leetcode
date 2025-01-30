class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        visited = [[0 for _ in range(len(image[0]))] for _ in range(len(image))]
        x = [1,-1,0,0]
        y = [0,0,1,-1]
        start = image[sr][sc]
        def myFun(i,j):
            visited[i][j] = 1
            image[i][j] = color
            for k in range(4):
                nexti = i + x[k]
                nextj = j + y[k]
                if nexti >= 0 and nexti < len(image) and nextj >= 0 and nextj < len(image[0]) and visited[nexti][nextj] == 0 and image[nexti][nextj] == start:
                    myFun(nexti,nextj)
        myFun(sr,sc)
        return image