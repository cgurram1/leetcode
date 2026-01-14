class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        prefix = []
        vowels = ['a','e','i','o','u']
        count = 0
        result = []
        for word in words:
            if word[0] in vowels and word[-1] in vowels:
                count+=1
            prefix.append(count)
        # print(prefix)
        for query in queries:
            if(query[0] == 0):
                result.append(prefix[query[1]])
            else:
                result.append(prefix[query[1]] - prefix[query[0]-1])
        return result
