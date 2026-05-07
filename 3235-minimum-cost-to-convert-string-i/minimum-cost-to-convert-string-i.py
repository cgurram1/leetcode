class Solution:
    def minimumCost(self, source: str, target: str,
                    original: List[str], changed: List[str],
                    cost: List[int]) -> int:

        from collections import defaultdict

        adjMap = defaultdict(list)
        chars = set()
        distsMap = {}

        for i in range(len(changed)):

            fr = original[i]
            to = changed[i]

            adjMap[fr].append(to)
            distsMap[(fr, to)] = min(
                distsMap.get((fr, to), float('inf')),
                cost[i]
            )

            chars.add(fr)
            chars.add(to)
        for ch in chars:
            distsMap[(ch, ch)] = 0
        for via in chars:
            for fr in chars:
                for to in chars:

                    if (fr, to) not in distsMap:
                        distsMap[(fr, to)] = float('inf')

                    if (fr, via) not in distsMap:
                        distsMap[(fr, via)] = float('inf')

                    if (via, to) not in distsMap:
                        distsMap[(via, to)] = float('inf')

                    distsMap[(fr, to)] = min(
                        distsMap[(fr, to)],
                        distsMap[(fr, via)] + distsMap[(via, to)]
                    )

        totalCost = 0
        for i in range(len(source)):
            if source[i] != target[i]:
                if ((source[i], target[i]) not in distsMap or
                    distsMap[(source[i], target[i])] == float('inf')):
                    return -1
                totalCost += distsMap[(source[i], target[i])]
        return totalCost