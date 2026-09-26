class Solution {
    class CustomQueue {
        private int[] data;
        private int head;
        private int tail;
        private int size;
        private int capacity;

        public CustomQueue(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.head = 0;
            this.tail = 0;
            this.size = 0;
        }

        public void offer(int val) {
            data[tail] = val;
            tail = (tail + 1) % capacity;
            size++;
        }

        public int poll() {
            int val = data[head];
            head = (head + 1) % capacity;
            size--;
            return val;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        CustomQueue radiant = new CustomQueue(n);
        CustomQueue dire = new CustomQueue(n);

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}