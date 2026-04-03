class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        result = []
        inBlock = False
        for line in source:
            if not inBlock:
                newLine = []
            i = 0
            while i < len(line):
                if line[i:i+2] == "/*" and inBlock == False:
                    inBlock = True
                    i+=1
                elif line[i:i+2] == "*/" and inBlock:
                    inBlock = False
                    i+=1
                elif line[i:i+2] == "//" and not inBlock:
                    break
                elif not inBlock:
                    newLine.append(line[i])
                i+=1
            if not inBlock and newLine:
                result.append("".join(newLine))
        return result