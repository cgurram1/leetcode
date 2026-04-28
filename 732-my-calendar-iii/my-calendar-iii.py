class MyCalendarThree:

    def __init__(self):
        self.bookings = SortedDict()

    def book(self, startTime: int, endTime: int) -> int:
        self.bookings[startTime] = self.bookings.get(startTime,0) + 1
        self.bookings[endTime] = self.bookings.get(endTime,0) - 1
        maxResult = 0
        currVal = 0
        for key,val in self.bookings.items():
            currVal+=val
            maxResult = max(maxResult, currVal)
        return maxResult


# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(startTime,endTime)