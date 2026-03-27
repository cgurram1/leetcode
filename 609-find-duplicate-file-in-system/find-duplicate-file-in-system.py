class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        result = []
        contentMap = defaultdict(list)
        for path in paths:
            splits = path.split()
            directoryName = splits[0]
            for split in splits[1:]:
                fileName = split[:split.find('(')]
                fileContent = split[split.find('(') + 1:len(split)-1]
                contentMap[fileContent].append(f'{directoryName}/{fileName}')
        result = []
        for x in list(contentMap.values()):
            if len(x) > 1:
                result.append(x)
        return result

