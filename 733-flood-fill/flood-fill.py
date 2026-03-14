class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        visited = [[0]*len(image[0]) for _ in range(len(image))]
        def BFS(sr,sc):
            queue = [(sr,sc)]
            c = image[sr][sc]
            image[sr][sc] = color
            while queue:
                cr, cc = queue.pop()
                for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                    nr = cr + di
                    nc = cc + dj
                    if nr >= 0 and nr < len(image) and nc >= 0 and nc < len(image[0]) and visited[nr][nc] == 0 and image[nr][nc] == c:
                        visited[nr][nc] = 1
                        queue.append((nr,nc))
                        image[nr][nc] = color
            pass
        def DFS(r,c,rootColor):
            image[r][c] = color
            for di, dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                nr = r + di
                nc = c + dj
                if nr >= 0 and nr < len(image) and nc >= 0 and nc < len(image[0]) and visited[nr][nc] == 0 and image[nr][nc] == rootColor:
                    visited[nr][nc] = 1
                    DFS(nr,nc,rootColor)
        BFS(sr,sc)
        # DFS(sr,sc,image[sr][sc])
        return image