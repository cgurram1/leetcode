class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        processed = []
        for flower in flowers:
            processed.append((flower[0], 1))
            processed.append((flower[1] + 1, -1))
        processed.sort()
        people = sorted([(p, i) for i, p in enumerate(people)])
        f, p = 0, 0
        result = [0 for _ in range(len(people))]
        currentCount = 0
        while p < len(people):
            while f < len(processed) and processed[f][0] <= people[p][0]:
                currentCount += processed[f][1]
                f += 1
            result[people[p][1]] = currentCount
            p += 1
        return result