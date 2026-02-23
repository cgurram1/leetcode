class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        arr = list(dominoes)
        # print(arr)
        pushed = deque()
        # s = set()
        for i,ch in enumerate(arr):
            if(ch != '.'):
                pushed.append((i,ch))
        while(pushed):
            length = len(pushed)
            for i in range(length):
                index, push = pushed.popleft()
                if(push == 'L' and index - 1 >= 0 and arr[index - 1] == '.'):
                    if(index - 2 < 0 or arr[index - 2] != 'R'):
                        pushed.append((index - 1, 'L'))
                elif(push == 'R' and index + 1 < len(arr) and arr[index + 1] == '.'):
                    if(index + 2 >= len(arr) or arr[index + 2] != 'L'):
                        pushed.append((index + 1, 'R'))
            for i in range(len(pushed)):
                if(pushed[i][0] >= 0 and pushed[i][0] < len(arr)):
                    arr[pushed[i][0]] = pushed[i][1]
            # print(arr)
        return ''.join(arr)


            

