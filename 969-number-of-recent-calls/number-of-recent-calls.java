class RecentCounter {
    private int[] queue;
    private int head;
    private int tail;

    public RecentCounter() {
        // According to problem constraints, there are at most 10,000 calls to ping
        queue = new int[10000];
        head = 0;
        tail = 0;
    }
    
    public int ping(int t) {
        queue[tail++] = t;
        
        while (queue[head] < t - 3000) {
            head++;
        }
        
        return tail - head;
    }
}