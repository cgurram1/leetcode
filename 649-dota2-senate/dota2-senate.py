class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        R = deque()
        D = deque()
        for i,ch in enumerate(senate):
            if ch == 'R':
                R.append(i)
            else:
                D.append(i)
        while R and D:
            if R[0] < D[0]:
                R.append(R.popleft() + len(senate))
                D.popleft()
            else:
                D.append(D.popleft() + len(senate))
                R.popleft()
        if R:
            return "Radiant"
        return "Dire"

