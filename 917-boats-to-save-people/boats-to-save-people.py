class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people = sorted(people)
        res = 0
        r = len(people) - 1
        while(people[r] == limit):
            res+=1
            r-=1
        l = 0
        while(l < r):
            currSum = people[l] + people[r]
            if currSum > limit:
                r-=1
            elif currSum <= limit:
                # print("currSum",currSum)
                r-=1
                l+=1
            res+=1
        if l == r:
            return res+1
        return res