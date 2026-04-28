class MyCalendarTwo:

    def __init__(self):
        self.bookings = SortedDict()
        self.maxDays = 3

    def book(self, startTime: int, endTime: int) -> bool:
        curr_val = 0
        self.bookings[startTime] = self.bookings.get(startTime,0) + 1
        self.bookings[endTime] = self.bookings.get(endTime,0) - 1
        for key,val in self.bookings.items():
            curr_val += val
            if curr_val >= self.maxDays:
                self.bookings[startTime] = self.bookings.get(startTime,0) - 1
                self.bookings[endTime] = self.bookings.get(endTime,0) + 1
                return False
        return True


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(startTime,endTime)