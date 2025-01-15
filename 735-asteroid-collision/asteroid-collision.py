class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        arr = []
        i = 0
        while(i < len(asteroids)):
            curr = asteroids[i]
            inside = 0
            if curr < 0:
                while(arr and arr[-1] > 0 and -curr > arr[-1]):
                    arr.pop(-1)
                if arr and -curr == arr[-1]:
                    arr.pop(-1)
                elif not arr or (arr and arr[-1] < 0):
                    arr.append(curr)
            else:
                arr.append(curr)
            i+=1
        return arr