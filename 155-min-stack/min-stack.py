class MinStack(object):
    def __init__(self):
        self.st = []
        self.mini = float('Inf')
        
    def push(self, value):
        if not self.st :
            self.st.append(value)
            self.mini = value
        else :
            if value > self.mini :
                self.st.append(value)
            else :
                self.st.append(2*value-self.mini)
                self.mini = value
    def pop(self):
        if not self.st :
            return -1
        ele = self.st[-1]
        self.st.pop()
        if ele < self.mini :
            self.mini = 2*self.mini - ele 
 
    def top(self):
        if not self.st :
            return -1
        ele = self.st[-1]
        if self.mini < ele :
            return ele
        else :
            return self.mini
        
    def getMin(self):
        return self.mini
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()