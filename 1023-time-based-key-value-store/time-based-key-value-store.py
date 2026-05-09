"""

foo: {(1,bar), (4,bar)}

"""

class TimeMap:

    def __init__(self):
        self.timeMap = defaultdict(SortedDict)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.timeMap[key][timestamp] = value

    def get(self, key: str, timestamp: int) -> str:
        sd = self.timeMap[key].bisect_right(timestamp)
        # print(sd)
        # print(self.timeMap[key].items())
        if sd == 0:
            return ""
        return self.timeMap[key].items()[sd-1][1]
        


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)