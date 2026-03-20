class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        n = max([i[0] for i in stones]) + 1
        m = max([i[1] for i in stones]) + 1
        
        parent = [i for i in range(n+m)]

        def find(c):
            if c != parent[c]:
                parent[c] = find(parent[c])
            return parent[c]
        def union(c1,c2):
            parent[find(c2)] = find(c1)


        for stone in stones:
            if find(stone[0]) !=  find(n+stone[1]):
                union(stone[0],n+stone[1])
        parents = set()
        for stone in stones:
            parents.add(find(stone[0]))
            parents.add(find(n+stone[1]))
        return len(stones) - len(parents)

