class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], queries: List[List[int]]) -> List[int]:
        L = [[[x,i] for i,x in enumerate(nums)]]
        max_trim = max(queries, key=lambda x:x[1])[1]
        def fun(arr,z):
            buckets = [[] for _ in range(10)]
            result = []
            for item in arr:
                b_id = ord(item[0][-z])-ord('0')
                buckets[b_id].append(item)
            for bucket in buckets:
                # for item in bucket:
                result.extend(bucket)
            return result
        for i in range(max_trim):
            L.append(fun(L[i],i+1))
        result = []
        for query in queries:
            result.append(L[query[1]][query[0]-1][1])
        return result
